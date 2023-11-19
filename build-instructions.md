# build-instructions.md

The build machine needs some development tools installed.

Two of the primary packages you want are 'git' and 'build-essential' if you are using Ubuntu.

Yocto (bitbake) will prompt you for any other missing tools when you try invoking your first build.

The example configuration files for using the meta-stm32mp1 assume a certain directory structure.

You can change the structure and modify the configuration files to match.

This doc will explain assuming the structure in the examples.

From your home directory on a Ubuntu Linux system

Clone the repos listed in the README.md with the branches indicated

Start with the high-level poky repo

    ~$ git clone -b nanbield git://git.yoctoproject.org/poky.git poky-nanbield

Clone the remaining repos under poky-nanbield

    ~$ cd poky-nanbield

    ~/poky-nanbield$ git clone -b nanbield git://git.openembedded.org/meta-openembedded.git

    ~/poky-nanbield$ git clone -b nanbield git://git.yoctoproject.org/meta-security.git

    ~/poky-nanbield$ git clone -b 6.5 https://code.qt.io/yocto/meta-qt6.git

    ~/poky-nanbield$ git clone -b nanbield https://github.com/STMicroelectronics/meta-st-stm32mp.git


Then clone the repo where I am experimenting with customizations.
Do this in under another directory (again to follow my example conventions).

    ~$ mkdir ~/stm32mp1

    ~$ cd ~/stm32mp1

Clone the custom repo

    ~/stm32mp1$ git clone -b nanbield https://github.com/jumpnow/meta-stm32mp1.git

Create a build configuration directory

    ~/stm32mp1$ mkdir -p build/conf

Copy the example configuration files

    ~/stm32mp1$ cp meta-stm32mp1/conf/local.conf.sample build/conf/local.conf
    ~/stm32mp1$ cp meta-stm32mp1/conf/bblayers.conf.sample build/conf/bblayers.conf
    ~/stm32mp1$ cp meta-stm32mp1/conf/conf-notes.txt build/conf/conf-notes.txt

Edit the configuration files, the build/conf/local.conf file is one you might want to customize.

The three vars to look at if you don't have a lot of room on your $HOME partition

* DL_DIR      defaults to build/downloads, but you probably want this somewhere more permanent
* SSTATE_DIR  defaults to build/sstate, usually around 8GB
* TMPDIR      defaults to build/tmp, but this is the big one > 50GB

If you change any of these, make sure the user running bitbake can write to these directories


Invoke the build by first sourcing the Yocto environment then running bitbake the build tool.

The oe-init-build-env script will drop you in the build directory.

    ~$ source poky-nanbield/oe-init-build-env ~/stm32mp1/build
    ...
    ~/stm32mp1/build$


NOTE: Make sure to include the 'build' directory location as an argument to the oe-init-build-env
script or it will create a build directory in whatever directory you are currently in.
Not what you usually want.


Invoke the build of one of the images. Start with the console-image as all the others build
on it.

    ~/stm32mp1/build$ bitbake console-image


