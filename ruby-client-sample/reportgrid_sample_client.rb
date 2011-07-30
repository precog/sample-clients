require 'rubygems'
gem 'reportgrid', '= 0.3.1' 

require 'reportgrid'

client = ReportGrid::ReportGrid.new('A3BC1539-E8A9-4207-BB41-3036EC2C6E6D')

client.track("/ruby_sample_client", "interaction", {:type => 'click', :gender => 'male', :tags => ['fishing', 'hunting']})




