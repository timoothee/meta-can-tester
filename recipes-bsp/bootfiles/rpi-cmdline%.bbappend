do_deploy:append() {
    sed -i -e '1s/$/ quiet logo.nologo vt.global_cursor_default=0/' "${WORKDIR}/cmdline.txt"
}