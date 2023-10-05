FILESEXTRAPATHS:prepend := "${THISDIR}/linux-stm32mp:"

SRC_URI += "file://custom-config"

KERNEL_DEFCONFIG = ""

KERNEL_EXTERNAL_DEFCONFIG = "custom-config"
