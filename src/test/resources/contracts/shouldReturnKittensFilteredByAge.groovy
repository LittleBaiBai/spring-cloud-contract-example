import org.springframework.cloud.contract.spec.Contract
//https://cloud.spring.io/spring-cloud-contract/1.1.x/multi/multi__contract_dsl.html
Contract.make {
    description('''
given:
	there is a list of kittens
when:
	GET /kittens
then:
	get a list of kittens
''')
    request {
        method 'GET'
        urlPath('/kittens') {
            queryParameters {
                parameter 'age': value(anyPositiveInt(), producer(5))
            }
        }
        headers {
            contentType(applicationJson())
        }
    }
    response {
        status 200
//        body("""
//  {
//    "fraudCheckStatus": "FRAUD",
//    "rejectionReason": "Amount too high"
//  }
//  """)
        body ([
                name: $(consumer('Chocobo'), producer(regex('[a-zA-Z]+'))),
                age: fromRequest().query("age"),
        ])
        headers {
            contentType(applicationJson())
        }
    }
}