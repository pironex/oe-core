require gstreamer1.0-plugins.inc

LICENSE = "GPLv2+ & LGPLv2+ & LGPLv2.1+ "

DEPENDS += "gstreamer1.0-plugins-base bzip2 libpng jpeg"

S = "${WORKDIR}/gst-plugins-bad-${PV}"

inherit gettext

# opengl packageconfig factored out to make it easy for distros
# and BSP layers to pick either (desktop) opengl, gles2, or no GL
PACKAGECONFIG_GL ?= "${@bb.utils.contains('DISTRO_FEATURES', 'opengl', 'gles2', '', d)}"

PACKAGECONFIG ??= " \
    ${PACKAGECONFIG_GL} \
    ${@bb.utils.contains('DISTRO_FEATURES', 'wayland', 'wayland', '', d)} \
    ${@bb.utils.contains('DISTRO_FEATURES', 'bluetooth', 'bluez', '', d)} \
    ${@bb.utils.contains('DISTRO_FEATURES', 'directfb', 'directfb', '', d)} \
    orc curl uvch264 neon sndfile \
    hls sbc dash bz2 smoothstreaming \
    "

# dash = Dynamic Adaptive Streaming over HTTP
PACKAGECONFIG[assrender]       = "--enable-assrender,--disable-assrender,libass"
PACKAGECONFIG[curl]            = "--enable-curl,--disable-curl,curl"
PACKAGECONFIG[gles2]           = "--enable-gles2 --enable-egl,--disable-gles2 --disable-egl,virtual/libgles2 virtual/egl"
PACKAGECONFIG[opengl]          = "--enable-opengl,--disable-opengl,virtual/libgl libglu"
PACKAGECONFIG[faac]            = "--enable-faac,--disable-faac,faac"
PACKAGECONFIG[faad]            = "--enable-faad,--disable-faad,faad2"
PACKAGECONFIG[libmms]          = "--enable-libmms,--disable-libmms,libmms"
PACKAGECONFIG[modplug]         = "--enable-modplug,--disable-modplug,libmodplug"
PACKAGECONFIG[mpg123]          = "--enable-mpg123,--disable-mpg123,mpg123"
PACKAGECONFIG[opus]            = "--enable-opus,--disable-opus,libopus"
PACKAGECONFIG[flite]           = "--enable-flite,--disable-flite,flite-alsa"
PACKAGECONFIG[opencv]          = "--enable-opencv,--disable-opencv,opencv"
PACKAGECONFIG[wayland]         = "--enable-wayland,--disable-wayland,wayland"
PACKAGECONFIG[uvch264]         = "--enable-uvch264,--disable-uvch264,libusb1 udev"
PACKAGECONFIG[directfb]        = "--enable-directfb,--disable-directfb,directfb"
PACKAGECONFIG[neon]            = "--enable-neon,--disable-neon,neon"
PACKAGECONFIG[openal]          = "--enable-openal,--disable-openal,openal-soft"
PACKAGECONFIG[hls]             = "--enable-hls,--disable-hls,gnutls"
PACKAGECONFIG[sbc]             = "--enable-sbc,--disable-sbc,sbc"
PACKAGECONFIG[dash]            = "--enable-dash,--disable-dash,libxml2"
PACKAGECONFIG[bz2]             = "--enable-bz2,--disable-bz2,bzip2"
PACKAGECONFIG[fluidsynth]      = "--enable-fluidsynth,--disable-fluidsynth,fluidsynth"
PACKAGECONFIG[schroedinger]    = "--enable-schro,--disable-schro,schroedinger"
PACKAGECONFIG[smoothstreaming] = "--enable-smoothstreaming,--disable-smoothstreaming,libxml2"
PACKAGECONFIG[bluez]           = "--enable-bluez,--disable-bluez,bluez4"
PACKAGECONFIG[rsvg]            = "--enable-rsvg,--disable-rsvg,librsvg"
PACKAGECONFIG[sndfile]         = "--enable-sndfile,--disable-sndfile,libsndfile1"
PACKAGECONFIG[webp]            = "--enable-webp,--disable-webp,libwebp"

# these plugins have not been ported to 1.0 (yet):
#   directdraw vcd apexsink dc1394 lv2 linsys musepack mythtv
#   nas timidity teletextdec sdl xvid wininet acm gsettings
#   sndio qtwrapper cdxaparse dccp faceoverlay hdvparse tta
#   mve nuvdemux osx_video patchdetect quicktime real sdi
#   videomeasure gsettings

# these plugins have no corresponding library in OE-core or meta-openembedded:
#   openni2 winks direct3d directdraw directsound winscreencap osx_video
#   apple_media android_media avc chromaprint daala dts gme gsm kate ladspa mimic
#   mpeg2enc mplex ofa openjpeg opensles pvr resindvd rtmp soundtouch spandsp spc
#   srtp vdpau voaacenc voamrwbenc wasapi zbar

EXTRA_OECONF += " \
    --enable-dvb \
    --enable-shm \
    --enable-fbdev \
    --enable-decklink \
    --disable-acm \
    --disable-android_media \
    --disable-apexsink \
    --disable-apple_media \
    --disable-avc \
    --disable-chromaprint \
    --disable-daala \
    --disable-dc1394 \
    --disable-direct3d \
    --disable-directdraw \
    --disable-directsound \
    --disable-dts \
    --disable-gme \
    --disable-gsettings \
    --disable-gsm \
    --disable-kate \
    --disable-ladspa \
    --disable-linsys \
    --disable-lv2 \
    --disable-mimic \
    --disable-mpeg2enc \
    --disable-mplex \
    --disable-musepack \
    --disable-mythtv \
    --disable-nas \
    --disable-ofa \
    --disable-openjpeg \
    --disable-opensles \
    --disable-osx_video \
    --disable-pvr \
    --disable-quicktime \
    --disable-resindvd \
    --disable-rtmp \
    --disable-sdl \
    --disable-sdltest \
    --disable-sndio \
    --disable-soundtouch \
    --disable-spandsp \
    --disable-spc \
    --disable-srtp \
    --disable-teletextdec \
    --disable-timidity \
    --disable-vcd \
    --disable-vdpau \
    --disable-voaacenc \
    --disable-voamrwbenc \
    --disable-wasapi \
    --disable-wildmidi \
    --disable-wininet \
    --disable-winscreencap \
    --disable-xvid \
    --disable-zbar \
    ${GSTREAMER_1_0_ORC} \
    "

ARM_INSTRUCTION_SET = "arm"

FILES_gstreamer1.0-plugins-bad-opencv += "${datadir}/gst-plugins-bad/1.0/opencv*"

