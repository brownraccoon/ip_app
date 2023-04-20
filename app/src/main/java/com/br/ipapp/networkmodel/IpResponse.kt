package com.br.ipapp.networkmodel

import com.google.gson.annotations.SerializedName

data class IpResponse(

	@field:SerializedName("utc_offset")
	val utcOffset: String? = null,

	@field:SerializedName("country")
	val country: String? = null,

	@field:SerializedName("country_tld")
	val countryTld: String? = null,

	@field:SerializedName("country_population")
	val countryPopulation: Int? = null,

	@field:SerializedName("city")
	val city: String? = null,

	@field:SerializedName("timezone")
	val timezone: String? = null,

	@field:SerializedName("latitude")
	val latitude: Any? = null,

	@field:SerializedName("network")
	val network: String? = null,

	@field:SerializedName("country_area")
	val countryArea: Any? = null,

	@field:SerializedName("country_code_iso3")
	val countryCodeIso3: String? = null,

	@field:SerializedName("country_name")
	val countryName: String? = null,

	@field:SerializedName("currency")
	val currency: String? = null,

	@field:SerializedName("country_capital")
	val countryCapital: String? = null,

	@field:SerializedName("country_calling_code")
	val countryCallingCode: String? = null,

	@field:SerializedName("longitude")
	val longitude: Any? = null,

	@field:SerializedName("currency_name")
	val currencyName: String? = null,

	@field:SerializedName("languages")
	val languages: String? = null,

	@field:SerializedName("org")
	val org: String? = null,

	@field:SerializedName("ip")
	val ip: String? = null,

	@field:SerializedName("continent_code")
	val continentCode: String? = null,

	@field:SerializedName("version")
	val version: String? = null,

	@field:SerializedName("country_code")
	val countryCode: String? = null,

	@field:SerializedName("in_eu")
	val inEu: Boolean? = null,

	@field:SerializedName("postal")
	val postal: String? = null,

	@field:SerializedName("region")
	val region: String? = null,

	@field:SerializedName("asn")
	val asn: String? = null,

	@field:SerializedName("region_code")
	val regionCode: String? = null
)
