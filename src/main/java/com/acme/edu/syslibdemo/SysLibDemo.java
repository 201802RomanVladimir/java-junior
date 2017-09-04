package com.acme.edu.syslibdemo;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class SysLibDemo {
    public static void main(String[] args) {
        System.getProperties(); //java -Dkey=val -Dfile.encoding=cp866 MyClass

        /*
        apple.laf.useScreenMenuBar=true
awt.toolkit=sun.lwawt.macosx.LWCToolkit
file.encoding=UTF-8 | Cp866 | windows-1251
file.encoding.pkg=sun.io
file.separator=/
ftp.nonProxyHosts=local|*.local|169.254/16|*.169.254/16
gopherProxySet=false
http.nonProxyHosts=local|*.local|169.254/16|*.169.254/16
java.awt.graphicsenv=sun.awt.CGraphicsEnvironment
java.awt.printerjob=sun.lwawt.macosx.CPrinterJob
java.class.path=/Library/Java/JavaVirtualMachines/jdk1.8.0_131.jdk/Contents/Home/lib/visualvm/platform/lib/boot.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_131.jdk/Contents/Home/lib/visualvm/platform/lib/org-openide-modules.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_131.jdk/Contents/Home/lib/visualvm/platform/lib/org-openide-util-lookup.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_131.jdk/Contents/Home/lib/visualvm/platform/lib/org-openide-util.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_131.jdk/Contents/Home/lib/visualvm/platform/lib/locale/boot_ja.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_131.jdk/Contents/Home/lib/visualvm/platform/lib/locale/boot_zh_CN.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_131.jdk/Contents/Home/lib/visualvm/platform/lib/locale/org-openide-modules_ja.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_131.jdk/Contents/Home/lib/visualvm/platform/lib/locale/org-openide-modules_zh_CN.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_131.jdk/Contents/Home/lib/visualvm/platform/lib/locale/org-openide-util-lookup_ja.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_131.jdk/Contents/Home/lib/visualvm/platform/lib/locale/org-openide-util-lookup_zh_CN.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_131.jdk/Contents/Home/lib/visualvm/platform/lib/locale/org-openide-util_ja.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_131.jdk/Contents/Home/lib/visualvm/platform/lib/locale/org-openide-util_zh_CN.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_131.jdk/Contents/Home/lib/dt.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_131.jdk/Contents/Home/lib/tools.jar
java.class.version=52.0
java.endorsed.dirs=/Library/Java/JavaVirtualMachines/jdk1.8.0_131.jdk/Contents/Home/jre/lib/endorsed
java.ext.dirs=/Users/eugene/Library/Java/Extensions:/Library/Java/JavaVirtualMachines/jdk1.8.0_131.jdk/Contents/Home/jre/lib/ext:/Library/Java/Extensions:/Network/Library/Java/Extensions:/System/Library/Java/Extensions:/usr/lib/java
java.home=/Library/Java/JavaVirtualMachines/jdk1.8.0_131.jdk/Contents/Home/jre
java.io.tmpdir=/var/folders/b1/c78j7s0s3qx46kgr5nctg_qh0000gn/T/
java.library.path=/Users/eugene/Library/Java/Extensions:/Library/Java/Extensions:/Network/Library/Java/Extensions:/System/Library/Java/Extensions:/usr/lib/java:.
java.runtime.name=Java(TM) SE Runtime Environment
java.runtime.version=1.8.0_131-b11
java.specification.name=Java Platform API Specification
java.specification.vendor=Oracle Corporation
java.specification.version=1.8
java.util.logging.config.class=org.netbeans.core.startup.TopLogging
java.vendor=Oracle Corporation
java.vendor.url=http://java.oracle.com/
java.vendor.url.bug=http://bugreport.sun.com/bugreport/
java.version=1.8.0_131
java.vm.info=mixed mode
java.vm.name=Java HotSpot(TM) 64-Bit Server VM
java.vm.specification.name=Java Virtual Machine Specification
java.vm.specification.vendor=Oracle Corporation
java.vm.specification.version=1.8
java.vm.vendor=Oracle Corporation
java.vm.version=25.131-b11
jdk.home=/Library/Java/JavaVirtualMachines/jdk1.8.0_131.jdk/Contents/Home
line.separator=\n
nb.native.filechooser=false
netbeans.buildnumber=20170114-unknown-revn
netbeans.default_userdir_root=/Users/eugene/Library/Application Support/VisualVM
netbeans.dirs=/Library/Java/JavaVirtualMachines/jdk1.8.0_131.jdk/Contents/Home/lib/visualvm/visualvm:/Library/Java/JavaVirtualMachines/jdk1.8.0_131.jdk/Contents/Home/lib/visualvm/profiler:
netbeans.dynamic.classpath=/Library/Java/JavaVirtualMachines/jdk1.8.0_131.jdk/Contents/Home/lib/visualvm/platform/core/core.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_131.jdk/Contents/Home/lib/visualvm/platform/core/org-openide-filesystems.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_131.jdk/Contents/Home/lib/visualvm/platform/core/locale/core_ja.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_131.jdk/Contents/Home/lib/visualvm/platform/core/locale/core_zh_CN.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_131.jdk/Contents/Home/lib/visualvm/platform/core/locale/org-openide-filesystems_ja.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_131.jdk/Contents/Home/lib/visualvm/platform/core/locale/org-openide-filesystems_zh_CN.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_131.jdk/Contents/Home/lib/visualvm/visualvm/core/com-sun-tools-visualvm-modules-startup.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_131.jdk/Contents/Home/lib/visualvm/visualvm/core/locale/com-sun-tools-visualvm-modules-startup_ja.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_131.jdk/Contents/Home/lib/visualvm/visualvm/core/locale/com-sun-tools-visualvm-modules-startup_zh_CN.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_131.jdk/Contents/Home/lib/visualvm/visualvm/core/locale/core_visualvm.jar
netbeans.home=/Library/Java/JavaVirtualMachines/jdk1.8.0_131.jdk/Contents/Home/lib/visualvm/platform
netbeans.keyring.no.master=true
netbeans.productversion=Java VisualVM
netbeans.user=/Users/eugene/Library/Application Support/VisualVM/8u131
org.openide.major.version=IDE/1
org.openide.specification.version=6.2
org.openide.version=deprecated
org.xml.sax.driver=com.sun.org.apache.xerces.internal.jaxp.SAXParserImpl$JAXPSAXParser
os.arch=x86_64
os.name=Mac OS X
os.version=10.12.6
path.separator=:
plugin.manager.install.global=false
socksNonProxyHosts=local|*.local|169.254/16|*.169.254/16
sun.arch.data.model=64
sun.awt.datatransfer.timeout=1000
sun.awt.enableExtraMouseButtons=true
sun.boot.class.path=/Library/Java/JavaVirtualMachines/jdk1.8.0_131.jdk/Contents/Home/jre/lib/resources.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_131.jdk/Contents/Home/jre/lib/rt.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_131.jdk/Contents/Home/jre/lib/sunrsasign.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_131.jdk/Contents/Home/jre/lib/jsse.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_131.jdk/Contents/Home/jre/lib/jce.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_131.jdk/Contents/Home/jre/lib/charsets.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_131.jdk/Contents/Home/jre/lib/jfr.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_131.jdk/Contents/Home/jre/classes
sun.boot.library.path=/Library/Java/JavaVirtualMachines/jdk1.8.0_131.jdk/Contents/Home/jre/lib
sun.cpu.endian=little
sun.cpu.isalist=
sun.font.fontmanager=sun.font.CFontManager
sun.io.unicode.encoding=UnicodeBig
sun.java.command=org.netbeans.Main --cachedir /Users/eugene/Library/Caches/VisualVM/8u131 --userdir /Users/eugene/Library/Application Support/VisualVM/8u131 --branding visualvm
sun.java.launcher=SUN_STANDARD
sun.java2d.d3d=false
sun.java2d.noddraw=true
sun.jnu.encoding=UTF-8
sun.jvmstat.perdata.syncWaitMs=10000
sun.management.compiler=HotSpot 64-Bit Tiered Compilers
sun.os.patch.level=unknown
user.country=US
user.country.format=RU
user.dir=/Users/eugene
user.home=/Users/eugene
user.language=en
user.name=eugene
user.timezone=Europe/Moscow
         */

        /*
        try {
            Runtime.getRuntime().exec("dir");
        } catch (IOException e) {
            e.printStackTrace();
        }
        */

        new Message("").equals(null);
        Objects.equals(1,2);

       Integer i1 = 127;
       Integer i2 = 127;
       System.out.println(i1 == i2);


    }
}

class Message extends Object {
    private String message;
    private Integer id;

    public Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Message message1 = (Message) o;

        if (message != null ?
                !message.equals(message1.message) :
                message1.message != null) return false;

        return id != null ?
                id.equals(message1.id) :
                message1.id == null;
    }

    @Override
    public int hashCode() {
        int result = message != null ? message.hashCode() : 0;
        result = 31 * result + (id != null ? id.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "{" +
                "message='" + message + '\'' +
                ", id=" + id +
                '}';
    }
}
