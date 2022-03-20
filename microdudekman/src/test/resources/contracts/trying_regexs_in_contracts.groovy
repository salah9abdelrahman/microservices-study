package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method(GET())
        url($(c(regex("/get/[0-9]")), p("/get/1")))
        body([
                duck    : 123,
                alpha   : 'abc',
                number  : 123,
                aBoolean: true,
                date    : '2022-03-03',
                dateTime: '2022-03-03T01:02:35',
                time    : '01:02:34'
        ])

        bodyMatchers {
            jsonPath('$.duck', byRegex("[0-9]{3}"))
            jsonPath('$.alpha', byRegex(onlyAlphaUnicode()))
            jsonPath('$.number', byRegex(number()))
            jsonPath('$.aBoolean', byRegex(anyBoolean()))
            jsonPath('$.date', byDate())
            jsonPath('$.dateTime', byTimestamp())
            jsonPath('$.time', byTime())
        }
    }

    response {
        status(OK())
        headers {
            contentType(applicationJson())
            headers {
                contentType(applicationJson())
                header([
                        second: $(anyAlphaNumeric())
                ])
            }
        }

        body([
                valueWithoutAMatcher: 'foo',
                valueWithTypeMatch  : 'string',
                valueWithMin        : [1, 2, 3],
                valueWithMax        : [1, 2, 3],
                valueWithMinAndMax  : [1, 2, 3],
                valueWithMinEmpty   : [],
                valueWithMaxEmpty   : [],
                nullValue           : null
        ])

        bodyMatchers {
            jsonPath('$.valueWithTypeMatch', byType())
            jsonPath('$.valueWithMin', byType { minOccurrence(1) })
            jsonPath('$.valueWithMax', byType { maxOccurrence(3) })
            jsonPath('$.valueWithMinAndMax', byType {
                minOccurrence(1)
                maxOccurrence(3)
            })
            // assert there is a value exist
            jsonPath('$.valueWithMinEmpty', byType { minOccurrence(0) })
            // assert that array is empty
            jsonPath('$.valueWithMaxEmpty', byType { maxOccurrence(0) })
            jsonPath('$.nullValue', byNull())

        }
    }
}