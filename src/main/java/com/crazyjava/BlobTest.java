package com.crazyjava;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;
import java.util.Queue;

/**
 * @Author: Richered
 * @Date: 2020/08/17 19:44
 * @Description:
 **/
public class BlobTest {

    JFrame jf = new JFrame("图片管理程序");

    private static Connection conn;

    private static PreparedStatement insert;

    private static PreparedStatement query;

    private static PreparedStatement queryAll;

    private DefaultListModel<ImageHolder> imageModel = new DefaultListModel<>();

    private JList<ImageHolder> imageList = new JList<>(imageModel);

    private JTextField filePath = new JTextField(26);

    private JButton browserBn = new JButton("....");

    private JButton uploadBn = new JButton("上传");

    private JLabel imageLabel = new JLabel();

    JFileChooser chooser = new JFileChooser(".");

    ExtensionFileFilter fileFilter = new ExtensionFileFilter();

    static {
        try {
            Properties props = new Properties();
            props.load(new FileInputStream("mysql.ini"));
            String driver = props.getProperty("driver");
            String url = props.getProperty("url");
            String user = props.getProperty("user");
            String pass = props.getProperty("pass");
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, pass);
            insert = conn.prepareStatement("insert into img_table values(null, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            query = conn.prepareStatement("select img_data from img_table where img_id = ?");
            queryAll = conn.prepareStatement("select img_id, img_name from img_table");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void init() throws SQLException{
        fileFilter.addExtension("jpg");
        fileFilter.addExtension("jpeg");
        fileFilter.addExtension("gif");
        fileFilter.addExtension("png");
        fileFilter.setDescription("图片文件(*.jpg, *.jpeg, *.gif, *.png)");
        chooser.addChoosableFileFilter(fileFilter);
        chooser.setAcceptAllFileFilterUsed(false);
        imageList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        JPanel jp = new JPanel();
        jp.add(filePath);
        jp.add(browserBn);
        browserBn.addActionListener(event -> {
            int result = chooser.showDialog(jf, "浏览图片文件上传");
            if (result == JFileChooser.APPROVE_OPTION){
                filePath.setText(chooser.getSelectedFile().getPath());
            }
        });
        jp.add(uploadBn);
        uploadBn.addActionListener(avt->{
            if (filePath.getText().trim().length() > 0){
                upload(filePath.getText());
                filePath.setText("");
            }
        });

        JPanel left = new JPanel();
        left.setLayout(new BorderLayout());
        left.add(new JScrollPane(imageLabel), BorderLayout.CENTER);
        left.add(jp, BorderLayout.SOUTH);
        jf.add(left);
        imageList.setFixedCellWidth(160);
        jf.add(new JScrollPane(imageList), BorderLayout.EAST);
        imageList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() >= 2){
                    ImageHolder cur = (ImageHolder) imageList.getSelectedValue();
                    try {
                        showImage(cur.getId());
                    }catch (SQLException sqle){
                        sqle.printStackTrace();
                    }
                }
            }
        });
        jf.setSize(620, 400);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
    }

    public void fillListModel() throws SQLException{
        try(ResultSet rs = queryAll.executeQuery()){
            imageModel.clear();
            while (rs.next()){
                imageModel.addElement(new ImageHolder(rs.getInt(1), rs.getString(2)));
            }
        }
    }

    public void upload(String fileName){
        String imageName = fileName.substring(fileName.lastIndexOf('\\') + 1, fileName.lastIndexOf('.'));
        File f = new File(fileName);
        try(FileInputStream is = new FileInputStream(f)){
            insert.setString(1, imageName);
            insert.setBinaryStream(2, is, (int)f.length());
            int affect = insert.executeUpdate();
            if (affect == 1){
                fillListModel();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void showImage(int id) throws SQLException{
        query.setInt(1, id);
        try(ResultSet rs = query.executeQuery()){
            if (rs.next()){
                Blob imageBlob = rs.getBlob(1);
                ImageIcon icon = new ImageIcon(imageBlob.getBytes(1L, (int)imageBlob.length()));
                imageLabel.setIcon(icon);
            }
        }
    }

    public static void main(String[] args) throws SQLException{
        new BlobTest().init();
    }
}
