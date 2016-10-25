import org.apache.commons.codec.net.URLCodec
import org.apache.commons.httpclient.URI
import org.apache.commons.httpclient.util.URIUtil
import org.apache.cxf.attachment.ContentDisposition;
import org.apache.cxf.attachment.Rfc5987Util;

println "Hello!"


def encode = { str ->
    return str.toString().split("%").collect { URIUtil.encodeWithinPath(it, "UTF-8") }.join("%25")
}

def encode0 = { str ->
    return URIUtil.encodeWithinPath(str.toString(), "UTF-8")
}

//println encode0("/;=?")
println encode0("%") // ????

println encode0("-_.!-*'()")
println encode0(":@&=+\$,") // =
println encode0(";") // ;
println encode0("/") // /
println encode0("%") // ????
println encode0("æ") // ????


println encode0("#%%25")

println new String(URLCodec.encodeUrl(URI.allowed_within_path, "a".getBytes("UTF-8")))
println new String(URLCodec.encodeUrl(URI.allowed_within_path, "/%?".getBytes("UTF-8")))

println ""

println encode("a% b !%^@/\$\\%c")
println encode("/docu ments%%25%2Fcompany/")
println encode0("/docu ments%%25%2Fcompany/")
println URLEncoder.encode("/docu ments%%25%2Fcompany/", "UTF-8")

println "------"
//def s = "/docu ments%25%2Fcompany/"
def s = "/documents%25%2Fcompany/"
println s
//println new URI(s).toString()
println URI.create(s).toString()

println URLEncoder.encode("a%b", "UTF-8").toString()
println URI.create("a%b").toString()

println URLEncoder.encode("foo-ä-€000 +%.html", "UTF-8")

println Rfc5987Util.encode("foo-ä-€000 +%\".html", "UTF-8")

//println new ContentDisposition("foo-ä-€000 +%.html").toString()

println org.apache.commons.lang3.StringEscapeUtils.unescapeJava("a{3}<>?+[ %~(中文).pdf");



