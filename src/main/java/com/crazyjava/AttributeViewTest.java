package com.crazyjava;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.nio.file.attribute.*;
import java.util.Date;
import java.util.List;

/**
 * @Author: Richered
 * @Date: 2020/09/01 19:28
 * @Description:
 **/
public class AttributeViewTest {

    public static void main(String[] args) throws Exception{

        Path testPath = Paths.get("AttributeViewTest.java");

        BasicFileAttributeView basicView = Files.getFileAttributeView(testPath, BasicFileAttributeView.class);

        BasicFileAttributes basicAttribs = basicView.readAttributes();

        System.out.println("创建时间" + new Date(basicAttribs.creationTime().toMillis()));

        System.out.println("最后访问时间" + new Date(basicAttribs.lastAccessTime().toMillis()));

        System.out.println("最后修改时间:" + new Date(basicAttribs.lastModifiedTime().toMillis()));

        System.out.println("文件大小:" + basicAttribs.size());

        FileOwnerAttributeView ownerView = Files.getFileAttributeView(testPath, FileOwnerAttributeView.class);

        System.out.println(ownerView.getOwner());

        UserPrincipal user = FileSystems.getDefault().getUserPrincipalLookupService().lookupPrincipalByGroupName("guest");

        ownerView.setOwner(user);

        UserDefinedFileAttributeView userView = Files.getFileAttributeView(testPath, UserDefinedFileAttributeView.class);

        List<String> attsNames = userView.list();

        for (String name: attsNames){
            ByteBuffer buf = ByteBuffer.allocate(userView.size(name));
            userView.read(name, buf);
            buf.flip();
            String value = Charset.defaultCharset().decode(buf).toString();
            System.out.println(name + "-->"+value);
        }

        userView.write("发行者" , Charset.defaultCharset().encode("疯狂java联盟"));

        DosFileAttributeView dosView = Files.getFileAttributeView(testPath, DosFileAttributeView.class);

        dosView.setHidden(true);

        dosView.setReadOnly(true);
    }
}
