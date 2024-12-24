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
    ninja \
    pkgconfig \
    python3-modules \
    strace \
"

OPENCV_DEV = " \
    libopencv-core \
    libopencv-core-dev \
    libopencv-features2d \
    libopencv-features2d-dev \
    libopencv-imgproc \
    libopencv-imgproc-dev \
    libopencv-shape \
    libopencv-shape-dev \
"

IMAGE_INSTALL += " \
    ${DEV_SDK} \
    ${OPENCV_DEV} \
"

export IMAGE_BASENAME = "console-dev-image"
