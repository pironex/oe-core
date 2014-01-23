MAJOR_VERSION = "2.24"
require util-linux.inc

LIC_FILES_CHKSUM = "file://README.licensing;md5=1715f5ee3e01203ca1e1e0b9ee65918c \
                    file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263 \ 
                    file://Documentation/licenses/COPYING.GPLv2;md5=b234ee4d69f5fce4486a80fdaf4a4263 \ 
                    file://Documentation/licenses/COPYING.LGPLv2.1;md5=4fbd65380cdd255951079008b364516c \ 
                    file://Documentation/licenses/COPYING.BSD-3;md5=58dcd8452651fc8b07d1f65ce07ca8af \ 
                    file://Documentation/licenses/COPYING.UCB;md5=263860f8968d8bafa5392cab74285262 \ 
                    file://libuuid/COPYING;md5=b442ffb762cf8d3e9df1b99e0bb4af70 \
                    file://libmount/COPYING;md5=fb93f01d4361069c5616327705373b16 \
                    file://libblkid/COPYING;md5=fb93f01d4361069c5616327705373b16"


SRC_URI += "file://util-linux-ng-replace-siginterrupt.patch \
            file://util-linux-ng-2.16-mount_lock_path.patch \
            file://uclibc-__progname-conflict.patch \
            file://configure-sbindir.patch \
"

SRC_URI[md5sum] = "88d46ae23ca599ac5af9cf96b531590f"
SRC_URI[sha256sum] = "835eb6232cfab0118ef2e4fd649de0ba9f5bd1b8cbf9a7d4d84594541dec8410"

CACHED_CONFIGUREVARS += "scanf_cv_alloc_modifier=as"
