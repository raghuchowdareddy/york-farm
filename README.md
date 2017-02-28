# york-farm
Online York Farm Framework
Issue #1: PKIX path building failed: SSLSecurity issue
Solution:
 1.In your mac terminal execute below command. hub.docker.com is just an example. it could be any url which needs to douwnload certificate 
   $ keytool -printcert -rfc -sslserver hub.docker.com > hub-docker.cert
 2. Run below command in the same terminal
    keytool -import -alias "hub-docker" -keystore "/Library/Java/JavaVirtualMachines/jdk1.8.0_101.jdk/Contents/Home/jre/lib/security/cacerts" -file hub-docker.cert
 3.passward : changeit
 4.if any perimssion denied while runnig spte 2. provide permission by help of below link
 https://support.apple.com/kb/PH18894?locale=en_GB
