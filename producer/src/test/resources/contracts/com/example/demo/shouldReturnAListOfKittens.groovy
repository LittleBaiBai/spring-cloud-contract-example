package contracts.com.example.demo

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
        url'/kittens'
    }
    response {
        status 200
        body ([[
                name: $(consumer('Chocobo'), producer(regex('[a-zA-Z]+'))),
                age: $(consumer(3), producer(anyPositiveInt())),
        ]])
        headers {
            contentType(applicationJson())
        }
    }
}