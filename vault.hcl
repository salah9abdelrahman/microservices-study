storage "file" {
  path    = "./vault/data"
  node_id = "node1"
}

# not on production
listener "tcp" {
  tls_disable = "true"
}

#
api_addr = "http://127.0.0.1:8200"
cluster_addr = "https://127.0.0.1:8201"

ui = true
disable_mlock = true

# #curl -X "GET" "http://127.0.0.1:8200/service-another-micro-dude/default" -H "X-Config-Token: s.gxYcerMrt4znDTMcWG1fyiQb"