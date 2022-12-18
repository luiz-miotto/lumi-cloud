require 'net/http'
require 'net/https'
require 'json'
require 'faraday'
require 'faraday_middleware'
require './api.rb'

@base_url = "https://api.alpha.sightplan.com"

@binding_id = "285e19e3"
@client_id = '3f6b6aa5-28b8-49d1-8ecb-f66d3baed575'
@client_secret = '0ILx9rdQieKpzx5J'

@property_id = "dipen-alpha-site"
@location_id = "bf25689d-7c11-457c-a507-a868ce29fc95"

puts "***************"
puts "TESTNG BINDING #{@binding_id}"
puts "***************"

access_token = send_request
puts "TOKEN RESULT = #{access_token.present? ? "SUCCESS" : "FAILED"}"
puts access_token

if (access_token.present?)

  r = send_request_task(access_token)
  puts "TASK RESULT = #{r.present? ? "SUCCESS" : "FAILED"}"

  sleep 1

  puts "\n\n\n"
  r = send_request_search(access_token)
  puts "SEARCH RESULT = #{r.present? && r > 0 ? "SUCCESS" : "FAILED"}"

  sleep 1

  puts "\n\n\n"
  r = send_request_categories(access_token)
  puts "CATEGORIES RESULT = #{r.present? && r > 0 ? "SUCCESS" : "FAILED"}"
end
