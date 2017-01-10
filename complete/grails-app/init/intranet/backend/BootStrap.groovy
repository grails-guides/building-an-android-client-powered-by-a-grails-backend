package intranet.backend

import groovy.transform.CompileStatic

@CompileStatic
class BootStrap {

    def init = { servletContext ->
        announcements().each { it.save() }
    }
    def destroy = {
    }

    static List<Announcement> announcements() {
        [
                new Announcement(title: 'Grails Quickcast #1: Grails Interceptors', body: '''
<p>OCI &amp; DZone have partnered to launch a new series: the Grails Quickcasts, led by Jeff Brown, principal software engineer and Grails practice lead at OCI.</p>
<p>Got a [g|G]roovy 17 minutes? Watch a quarter-hour of pure coding by Grails co-founder Jeff Scott Brown. Grin as Grails lets you build a JVM web app as fast as those Ruby on Rails developers do it -- with all the muscle of the Java platform.</p>
<p>In the first video, Jeff talks Grails <a href="https://en.wikipedia.org/wiki/Interceptor_pattern" rel="nofollow">interceptors</a>. (Yes, <code>create-interceptor</code> actually creates an interceptor. Mind. Blown.)</p>
<p>This Quickcast assumes only basic familiarity with Groovy (which is pretty darn expressive anyway) and the MVC concept (which you already know). Also serves as an excellent introduction to the interceptor pattern in any language, because Grails' behind-the-scenes legwork lets you focus on the logic of the pattern.</p>
'''),
                new Announcement(title: 'Grails Quickcast #2: JSON Views', body: '''
<p>Grails co-founder Jeff Scott Brown continues his deep dives into Grails with another awesome&nbsp;<strong>Grails&nbsp;Quickcast</strong>, brought to you in collaboration with&nbsp;<a href="https://dzone.com/articles/oci-and-dzone-present-a-grails-quickcast-2" target="_blank">DZone</a>. In case you missed part 1, here's&nbsp;<a href="https://dzone.com/articles/oci-and-dzone-present-a-grails-quickcast-1" rel="nofollow" target="_blank">a dive into interceptors</a>.</p>
<p>In a delightful and informative 15 minutes, Brown probes&nbsp;<a href="http://grails.github.io/grails-views/latest/#_json_views" rel="nofollow" target="_blank">JSON views.</a>&nbsp;Beginning with a Grails 3.1.1 application, created with a standard web profile, Brown added a few custom domain classes. The artist class has albums associated with it, and is annotated with grails.rest.Resource.</p>
<p>The ultimate goal is publishing a REST API under&nbsp;<code>/artists</code>&nbsp;for managing instances of the&nbsp;<code>artist</code>&nbsp;class, and to support the JSON and XML formats.</p>
<p>Brown uses music examples, including&nbsp;<em>Space Oddity</em>&nbsp;by David Bowie (RIP), and&nbsp;<em>Close to the Edge</em>&nbsp;by Yes. Sending a request to&nbsp;<code>/artists</code>&nbsp;gives a list of artists all of whom have albums associated with them. While the app is running in development mode, the JSON files can be altered and the effects of those changes can be seen real-time in the application. For example, switching&nbsp;<code>"ArtistName": "Riverside"</code>&nbsp;to <code>"theArtistName": "Riverside"</code>.</p>
<p>This Quickcast assumes basic knowledge of Grails, JSON, and REST APIs. Check out Brown’s neat intro to JSON views!</p>
'''),

                new Announcement(title: 'Grails Quickcast #3: Multi-Project Builds', body: '''
<div id="HTMLBlock16241" class="HTMLBlock">
<iframe src="https://player.vimeo.com/video/167774338" width="640" height="360" frameborder="0" webkitallowfullscreen="" mozallowfullscreen="" allowfullscreen=""></iframe>
<p><a href="https://vimeo.com/167774338">Grails Quickcast #3 - Multi-Project Builds</a> from <a href="https://vimeo.com/objectcomputing">OCI</a> on <a href="https://vimeo.com">Vimeo</a>.</p>
</div>
<p>OCI is proud to partner with <a title="DZone" href="www.dzone.com" target="_blank">DZone</a> to launch a new series: the Grails Quickcasts, led by the OCI Grails Team including Grails co-founders Graeme Rocher and Jeff Scott Brown. <br><br>In this Quickcast, Graeme Rocher, Head of Grails Development at OCI, walks you through multi-project builds in Grails. Grails does a few handy things with multi-project builds and plugins, not the least of which being that Grails compiles your plugins first and puts the class and resources of those plugins directly in the classpath. This lets you make changes to your plugins and instantly see those changes in your build.</p>
'''),
                new Announcement(title: 'Grails Quickcast #4: Angular Scaffolding', body: '''
<div id="HTMLBlock20455" class="HTMLBlock">
<iframe src="https://player.vimeo.com/video/172777807" width="640" height="360" frameborder="0" webkitallowfullscreen="" mozallowfullscreen="" allowfullscreen=""></iframe>
<p><a href="https://vimeo.com/172777807">AngularJS Scaffolding With Grails 3</a> from <a href="https://vimeo.com/objectcomputing">OCI</a> on <a href="https://vimeo.com">Vimeo</a>.</p>
</div>
<p>In this Quickcast, OCI Engineer James Kleeh walks you through using the Angular Scaffolding for Grails to build a fully functional web app, using a simple blog format for demonstration. The tutorial explains how to have Grails set up a REST endpoint and all the Angular modules needed to get the web app running.</p>
'''),
                new Announcement(title: 'Retrieving Runtime Config Values In Grails 3', body: '''
<div class="ws_vimeo">
    <iframe src="//player.vimeo.com/video/179662316" width="500" height="281" frameborder="0" webkitallowfullscreen="" mozallowfullscreen="" allowfullscreen=""></iframe> <p><a href="http://vimeo.com/179662316">3D Printing</a> from <a href="http://vimeo.com/intel">Intel</a> on <a href="https://vimeo.com">Vimeo</a>.</p>
</div>
<p>In the fifth Grails QuickCast, Grails co-founder, Jeff Scott Brown, highlights some of the great features of the Grails framework. &nbsp;In less than 18 minutes, Jeff describes several techniques for retrieving configuration values at runtime, and discusses the pros and cons of these different techniques. For this Quickcast, you’ll need no more than a basic understanding of Grails.&nbsp;The Grails Quickcast series is brought to you from <a href="objectcomputing.com">OCI</a> and <a href="https://dzone.com/articles/oci-and-dzone-present-grails-quickcast-5-conventio" target="_blank">DZone</a>. &nbsp;</p>
<p>Grails leverages the “Convention Over Configuration” design paradigm, which functions to decrease the number of decisions that a developer using the framework is required to make without losing flexibility. This is one of the main reasons why Grails significantly increases developer productivity!</p>
<p>While Grails applications often involve considerably less configuration than&nbsp;similar applications built with other frameworks, some configuration may still be necessary. In this short video, Jeff shares a number of mechanisms that make it easy for Grails developers to define configuration values, and to gain access to those configuration values at runtime. &nbsp;</p>
<p>Visit the <a href="http://grailsblog.ociweb.com/posts/2016/08/31/retrieving-config-values.html" target="_blank">OCI Grails Team Blog</a> for an accompanying article.</p>
'''),
                new Announcement(title: 'Developing Grails 3 Applications With IntelliJ IDEA', body: '''
<div class="ws_vimeo">
    <iframe src="//player.vimeo.com/video/186362455" width="500" height="281" frameborder="0" webkitallowfullscreen="" mozallowfullscreen="" allowfullscreen=""></iframe> <p><a href="http://vimeo.com/186362455">3D Printing</a> from <a href="http://vimeo.com/intel">Intel</a> on <a href="https://vimeo.com">Vimeo</a>.</p>
</div>
<p>In the sixth Grails QuickCast, Grails co-founder, Jeff Scott Brown, introduces&nbsp;several tips and tricks related to building Grails 3 applications in IDEA.&nbsp;The Grails Quickcast series is brought to you from&nbsp;<a href="https://www.objectcomputing.com" target="_blank">OCI</a>&nbsp;and&nbsp;<a href="https://dzone.com/" target="_blank">DZone</a>. &nbsp;</p>
<p>Grails 3 is a high productivity framework for building web applications for the JVM. IntelliJ IDEA is a high productivity Integrated Development Environment (IDE) for building a variety of types of applications. IDEA has always had really great support for building Grails applications and, in particular, has the very best support of any IDE for doing development with Grails 3.<br>&nbsp;</p>
''')
        ]
    }
}
