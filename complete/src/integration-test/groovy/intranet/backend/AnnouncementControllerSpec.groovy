package intranet.backend

import grails.plugins.rest.client.RestBuilder
import grails.testing.mixin.integration.Integration
import org.springframework.beans.factory.annotation.Value
import spock.lang.Specification
import javax.servlet.http.HttpServletResponse


@Integration
class AnnouncementControllerSpec extends Specification {

    def "test body is present in announcements json payload of Api 1.0"() {
        given:
        RestBuilder rest = new RestBuilder()

        when: 'Requesting announcements for version 1.0'
        def resp = rest.get("http://localhost:${serverPort}/announcements/") { // <1>
            header("Accept-Version", "1.0") // <2>
        }

        then: 'the request was successful'
        resp.status == HttpServletResponse.SC_OK // <3>

        and: 'the response is a JSON Payload'
        resp.headers.get('Content-Type') == ['application/json;charset=UTF-8']

        and: 'json payload contains an array of annoucements with id, title and body'
        resp.json.each {
            assert it.id
            assert it.title
            assert it.body // <4>
        }
    }

    def "test body is NOT present in announcements json payload of Api 2.0"() {
        given:
        RestBuilder rest = new RestBuilder()

        when: 'Requesting announcements for version 2.0'
        def resp = rest.get("http://localhost:${serverPort}/announcements/") {
            header("Accept-Version", "2.0")
        }

        then: 'the request was successful'
        resp.status == HttpServletResponse.SC_OK

        and: 'the response is a JSON Payload'
        resp.headers.get('Content-Type') == ['application/json;charset=UTF-8']

        and: 'json payload contains an array of annoucements with id, title'
        resp.json.each {
            assert it.id
            assert it.title
            assert !it.body // <2>
        }
    }

    def "test detail of an announcement contains body in both version 1.0 and 2.0"() {
        given:
        RestBuilder rest = new RestBuilder()

        when: 'Requesting announcements for version 1.0'
        def annoucementId = 2 as Long
        def resp = rest.get("http://localhost:${serverPort}/announcements/${annoucementId}") {
            header("Accept-Version", "1.0")
        }

        then: 'the request was successful'
        resp.status == HttpServletResponse.SC_OK

        and: 'the response is a JSON Payload'
        resp.headers.get('Content-Type') == ['application/json;charset=UTF-8']

        and: 'json payload contains the complete annoucement'
        resp.json.id
        resp.json.title
        resp.json.body

        when: 'Requesting announcements for version 1.0'
        resp = rest.get("http://localhost:${serverPort}/announcements/${annoucementId}") {
            header("Accept-Version", "2.0")
        }

        then: 'the request was successful'
        resp.status == HttpServletResponse.SC_OK

        and: 'the response is a JSON Payload'
        resp.headers.get('Content-Type') == ['application/json;charset=UTF-8']

        and: 'json payload contains the complete annoucement'
        resp.json.id
        resp.json.title
        resp.json.body
    }
}
