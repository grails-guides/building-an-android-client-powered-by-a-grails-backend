package intranet.backend.v2

import grails.rest.RestfulController
import intranet.backend.Announcement

class AnnouncementController extends RestfulController {
    static namespace = 'v2'
    static responseFormats = ['json']

    AnnouncementController() {
        super(Announcement)
    }

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)

        def c = Announcement.createCriteria()
        def announcements = c.list(params) {
            projections {
                property('id')
                property('title')
            }
        }.collect { [id: it[0], title: it[1]] } as List<Map>
        respond announcements, model: [("${resourceName}Count".toString()): countResources()]
    }
}
