#!/bin/bash

echo "start installWeb"

cd /data/was/emtinstance/webapps/ROOT/WEB-INF/classes/static
unzip -o html-emt.zip
chown -R tomcat:tomcat *
#tar xvfz ROOT.war

echo "end installWeb"
