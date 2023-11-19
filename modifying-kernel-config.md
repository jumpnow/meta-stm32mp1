# modifying-kernel-config.md

Source the Yocto environment as usual

    ~$ source poky-nanbield/oe-init-build-env ~/stm32mp1/build

    ### Shell environment set up for builds. ###

    You can now run 'bitbake <target>'

    Tested targets are:
        console-image
        console-dev-image
        sdl2-dev-image
        qt6-image


    ~/stm32mp1/build$ bitbake -c menuconfig virtual/kernel

After you are done with changes and have saved the new config, copy it to this directory with whatever name you want

    ~/stm32mp1/build$ cp <TMPDIR>/work/stm32mp1-poky-linux-gnueabi/linux-stm32mp/6.1.28-stm32mp-r1-r0/build/.config
        ../meta-stm32mp1/recipes-kernel/linux/linux-stm32mp/stm32mp1/scrap-config


Then edit the recipe bbappend file to use this new config

    ~/stm32mp1/build$ vi ../meta-stm32mp1/recipes-kernel/linux/linux-stm32mp_6.1.bbappend

In two places, replace 'trimmed-config' with your 'scrap-config'

Then rebuild the kernel and the image

    ~/stm32mp1/build$ bitbake -c cleansstate virtual/kernel && bitbake virtual/kernel

    ~/stm32mp1/build$ bitbake -c cleansstate console-image && bitbake console-image

