
require 'net/http'
require 'net/https'
require 'json'

@binding_id = "285e19e3"
@client_id  = '7910a233-a525-489c-aa20-94f6933d70c9'
@client_secret  = 'AKC5NfKZeXq5ej5E'

# Get MOCK (GET )
def send_request
  pp  "Sending"
  token = 'eyJ0eXAiOiJKV1QiLCJraWQiOiJkZjczYzY0ODI3ZWJjMWIxNTJmZTY3MmMyZTZiZjU1YzVhOGZkNDQyMDI0ZTgxZjc5MWJlOTE2OWVkZDIwOWYxIiwiYWxnIjoiUlM1MTIifQ.eyJqdGkiOiI1N2Y4ZGRjYi01NTVhLTQ0MjEtYTdkYi0yODQ1YzlkOGZjZmUiLCJhdWQiOiJMTWlvdHRvLUV2ZXJpbmdoYW0tVGFza0FQSShGdW5uZWwpIiwiaXNzIjoiaHR0cHM6Ly9ldmVyaW5naGFtLmJldGEuc2lnaHRwbGFuLmNvbSIsInN1YiI6ImI5ZDBhNzM0LWFjYmItNGE2YS04NWY5LTY1OTRjYWE1NzRkNyIsImV4cCI6MTY2NjMxNjEyOCwiaWF0IjoxNjY2Mjg3MzI4LCJwZXJtaXNzaW9ucyI6bnVsbCwia2lkIjoiZGY3M2M2NDgyN2ViYzFiMTUyZmU2NzJjMmU2YmY1NWM1YThmZDQ0MjAyNGU4MWY3OTFiZTkxNjllZGQyMDlmMSIsImlkIjoiNzkxMGEyMzMtYTUyNS00ODljLWFhMjAtOTRmNjkzM2Q3MGM5IiwibG9jYXRpb25zIjpbIjU3N2RjOTJmLWNkYWItNDk5Mi1hZTJmLWQ5NjAwMzc4YmI5YyIsIjFiZGViYWE4LTZlNzMtNGE3Ny04OGNlLWUyOTNlMGQ1NGFlOSJdLCJzY29wZSI6WyJ0YXNrOnJlYWQiLCJ0YXNrOndyaXRlIl0sImFwaWtleSI6ImYzZDAzOGVjLTkwOGQtNGJkZC05NDM4LTU0NmNlM2VlODEzOCJ9.iqWM9utG5wJdNwySD2BGNLnOHFid7BlrlVzWbMhGuxg1z-5jlNHYWmyx8di685jq1DrKriiYnquUPhRK-Dayrbwko3JzWmFDl3qHAwlotgfuzBnaT8rN9lMb_m0xysAXjld9uBND2Bf40Qf23eaGyB_Wi9RV9yUiAsRFm04Q6vEd71rmOdPfJfGMO9zHONHXOdi6fFVdK3sQuNYJVqf2GLlQ6HGm7pKWvtfZ0M3W4mbqxKtI2ydXKiaxVrm0AUYRQ5DipqqHrvYD5ER-fhvXkvm-qsZP2w0qGdPZQDX40gftvpu6mW8NwJ0e3HsFuf08WdmquEPD3-5xVv3KjnYNYw'
  uri = URI("https://api.beta.sightplan.com/#{@binding_id}/tasks/577dc92f-cdab-4992-ae2f-d9600378bb9c.json")

  # Create client
  http = Net::HTTP.new(uri.host, uri.port)
  http.use_ssl = true
  http.verify_mode = OpenSSL::SSL::VERIFY_PEER
  dict = {

  }
  body = JSON.dump(dict)

  # Create Request
  req =  Net::HTTP::Get.new(uri)
  # Add headers
  req.add_field "Content-Type", "application/json"
  # Add headers
  req.add_field "Accept", "application/json"
  # Add headers
  req.add_field "Authorization", "Bearer #{token}"
  # Set body
  req.body = body

  # Fetch Request
  res = http.request(req)
  puts "Response HTTP Status Code: #{res.code}"
  puts "Response HTTP Response Body: #{res.body}"
rescue StandardError => e
  puts "HTTP Request failed (#{e.message})"
end


threads = []

20.times {
  threads << Thread.new { puts send_request }
}


threads.each(&:join)