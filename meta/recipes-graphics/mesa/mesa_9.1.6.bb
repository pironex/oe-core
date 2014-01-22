require ${BPN}.inc

SRCREV = "e714e264202a2842ca361bd4671884cdec0e3cf4"
SRC_URI = "git://anongit.freedesktop.org/mesa/mesa;branch=9.2 \
           file://0002-pipe_loader_sw-include-xlib_sw_winsys.h-only-when-HA.patch \
           file://0006-fix-out-of-tree-egl.patch \
           "

S = "${WORKDIR}/git"

