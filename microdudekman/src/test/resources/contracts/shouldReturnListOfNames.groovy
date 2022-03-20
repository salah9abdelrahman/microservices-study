package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method(GET())
        url("/provider/list")
    }
    response {
        status(OK())
        headers {
            contentType(applicationJson())
            body(["Salah", "Abdulrahman"])
        }
    }
}