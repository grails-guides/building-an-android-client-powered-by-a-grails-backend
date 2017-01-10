package intranet.backend

class Announcement {

    String title
    String body
    
    static constraints = {
        body nullable: true
    }

    static mapping = {
        body type: 'text'  // <1>
    }
}
