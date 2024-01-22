SUMMARY = "A console development image for some stm32mp boards"

require console-image.bb

DEV_SDK = " \
    binutils \
    binutils-symlinks \
    cmake \
    cpp \
    cpp-symlinks \
    elfutils elfutils-binutils \
    fmt fmt-dev \
    gcc \
    gcc-symlinks \
    gdb \
    g++ \
    g++-symlinks \
    gettext \
    git \
    ldd \
    libstdc++ \
    libstdc++-dev \
    libtool \
    ltrace \
    make \
    meson \
    ninja \
    perl-modules \
    pkgconfig \
    python3-modules \
    strace \
"

IMAGE_INSTALL += " \
    ${DEV_SDK} \
"

export IMAGE_BASENAME = "console-dev-image"
