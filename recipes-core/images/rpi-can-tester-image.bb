# Base this image on core-image-base
include recipes-core/images/core-image-base.bb

IMAGE_INSTALL:append = " \ 
			nano \
			cantester \
			scripts \
			keyboard-core-boot \
"
