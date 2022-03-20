package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description("""
        This is a desc yo!!!
    """)

    priority(100)

    name("to_have_different_name_other_than_the_name_of_the_file_yo")


    request {
        method(GET())

//        url("/info")
        urlPath("info") {
            queryParameters {
                parameter("first param name", "value 1")
                // another way for query parameters
                parameter([
                        second: "value 2", third: "value 3"
                ])
            }
        }

        headers {
            contentType(applicationJson())
            accept(applicationJson())
            header([
                    header_param: "header value 1"
            ])
        }

//        body("single value")

//        body(["list", "of", "values"])

        // map
//        body([
//                "key_1": "value 1",
//                "key_2": "value 2"
//        ])

        // a file
        body("a_file.json")

        cookies {
            cookie("first param name", "value 1")
            cookie([
                    second: "value 2"
            ])
        }

    }

    response {
        status(OK())

        fixedDelayMilliseconds(1000)

        headers {
            contentType(applicationJson())
            accept(applicationJson())
            header([
                    header_param: "header value 1"
            ])
        }

        cookies {
            cookie("first param name", "value 1")
            cookie([
                    second: "value 2"
            ])
        }

        body("a_file.json")

    }
}