SUMMARY = "Kernel 'dbus-like' code for the Linux kernel"

LICENSE = "LGPLv2+"
LIC_FILES_CHKSUM = "file://bus.c;beginline=7;endline=10;md5=7d4e724c14885945ad54d05f469f6d0b"

inherit module

PV = "0.0"

SRCREV = "cc55ddf6e5ab685a991fa587c0c7539cc2b95cdf"
SRC_URI = "git://github.com/gregkh/kdbus.git;protocol=https"

S = "${WORKDIR}/git"

EXTRA_OEMAKE = "KERNELDIR=${STAGING_KERNEL_DIR}"

# there's no modules_install target and the install target uses 'uname -r', so install the module manually
# '/lib/modules/${KERNEL_VERSION}' is lifted straight from module-strip.bbclass
do_install() {
	install -d ${D}/lib/modules/${KERNEL_VERSION}/kernel/drivers/kdbus
	install -m0644 kdbus.ko ${D}/lib/modules/${KERNEL_VERSION}/kernel/drivers/kdbus
}
