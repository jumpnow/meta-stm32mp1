FILESEXTRAPATHS:prepend := "${THISDIR}/linux-stm32mp:"

SRC_URI += "file://trimmed-config"

KERNEL_DEFCONFIG = ""

KERNEL_EXTERNAL_DEFCONFIG = "trimmed-config"
