FILESEXTRAPATHS:prepend := "${THISDIR}/linux-stm32mp:"

SRC_URI += "file://ts-module-config"

KERNEL_DEFCONFIG = ""

KERNEL_EXTERNAL_DEFCONFIG = "ts-module-config"
