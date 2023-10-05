SUMMARY = "A sdl2 development image for some stm32mp boards"

require console-dev-image.bb

IMAGE_INSTALL += " \
    libsdl2-dev \
"

export IMAGE_BASENAME = "sdl2-dev-image"
