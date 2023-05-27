# Getting access toke 
## http -f POST :8080/oauth2/token grant_type=client_credentials scope='user.read' -a admin-client:secret
# Introspecting an Access Token
## Save token to variable
## export TOKEN=jsjdsd
# http -f POST :8080/oauth2/introspect token=$TOKEN -a admin-client:secret