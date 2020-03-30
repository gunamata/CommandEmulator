#!/bin/bash
year=$(date +%Y)
find target -name "*.html" -exec sed -i -e "s/${year}. All rights reserved/2012-${year} commandemulator (tools4j), Ben Warner and Marco Terzer. All rights reserved/g" {} \;
