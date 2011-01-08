(ns leiningen.midje
  (:use [leiningen.util.ns :only [namespaces-in-dir]]
    [leiningen.compile :only [eval-in-project]]))

(defn require-namespaces-form [namespaces]
  `(do
    (require 'clojure.test)
    (alter-var-root (var clojure.test/*report-counters*)
      (fn [_#] (ref clojure.test/*initial-report-counters*)))
    (doseq [n# '~namespaces] (require n#))
    (let [passes# (:pass @clojure.test/*report-counters*)
          fails# (:fail @clojure.test/*report-counters*)
          failure-message# (condp = fails#
        0 (format "All claimed facts (%d) have been confirmed." passes#)
        1 (format "FAILURE: %d fact was not confirmed." fails#)
        (format "FAILURE: %d facts were not confirmed." fails#))
          potential-consolation# (condp = passes#
        0 ""
        1 "(But 1 was.)"
        (format "(But %d were.)" passes#))
          consolation# (if (> fails# 0) potential-consolation# "")]
      (println failure-message# consolation#))))

(defn midje [project & namespaces]
  (let [desired-namespaces (if (empty? namespaces)
    (concat (namespaces-in-dir (:test-path project))
      (namespaces-in-dir (:source-path project)))
    (map symbol namespaces))]
    (eval-in-project project
      (require-namespaces-form desired-namespaces))))






<link href= "https://github.com/marick/Midje/commits/master.atom" rel= "alternate" title= "Recent Commits to Midje:master" type= "application/atom+xml" / >

<meta name= "description" content= "Midje provides a migration path from clojure.test to a more flexible, readable, abstract, and gracious style of testing" / >
<script type= "text/javascript" >
GitHub.nameWithOwner = GitHub.nameWithOwner | | "marick/Midje" ;
GitHub.currentRef = 'master ';
GitHub.commitSHA = "ee953144be3dddf4209655eacd4c7f475858de10" ;
GitHub.currentPath = "leiningen/midje.clj" ;
GitHub.masterBranch = "master" ;


</script>


<script type= "text/javascript" >
var _gaq = _gaq | | [] ;
_gaq.push (['_setAccount ', 'UA-3769691-2 ']);
            _gaq.push (['_trackPageview ']);
                        (function () {
                          var ga = document.createElement ('script ') ;
                            ga.src = ('https: '== document.location.protocol ? 'https://ssl ': 'http://www ') + '.google-analytics.com/ga.js ';
                            ga.setAttribute ('async ', 'true ') ;
                              document.documentElement.firstChild.appendChild (ga) ;
                              }) () ;
                              </script>

                              </head>



                              <body class= "logged_in " >



                              <script type= "text/javascript" >
                              var _kmq = _kmq | | [] ;
                              function _kms (u) {
                                var s = document.createElement ('script ') ; var f = document.getElementsByTagName('script')[0]; s.type = 'text/javascript'; s.async = true;
                                  s.src = u ; f.parentNode.insertBefore(s, f);
                                  }
                                  _kms ('//i.kissmetrics.com/i.js ') ;_kms('//doug1izaerwt3.cloudfront.net/406e8bf3a2b8846ead55afb3cfaf6664523e3a54.1.js');
                                    </script>










                                    <div class= "subnavd" id= "main" >
                                    <div id= "header" class= "true" >

                                    <a class= "logo boring" href= "https://github.com/organizations/cyrusinnovation" >
                                    <img src= "/images/modules/header/logov3.png?changed" class= "default" alt= "github" / >
                                    <! [if !IE] >
                                    <img src= "/images/modules/header/logov3-hover.png" class= "hover" alt= "github" / >
                                    <! [endif] >
                                    </a>









                                    <div class= "userbox" >
                                    <div class= "avatarname" >
                                    <a href= "https://github.com/AlexBaranosky" ><img src= "https://secure.gravatar.com/avatar/7d2cc799db6f5916a1ca4df1259d7d32?s=140&d=https%3A%2F%2Fgithub.com%2Fimages%2Fgravatars%2Fgravatar-140.png" alt= "" width= "20" height= "20" / ></a>
                                    <a href= "https://github.com/AlexBaranosky" class= "name" >AlexBaranosky</a>



                                    <a href= "/inbox/notifications" class= "unread_count notifications_count new tooltipped downwards js-notification-count" title= "Unread Notifications" >1</a>

                                    </div>
                                    <ul class= "usernav" >
                                    <li><a href= "https://github.com/organizations/cyrusinnovation" >Dashboard</a></li>
                                    <li>

                                    <a href= "https://github.com/inbox" >Inbox</a>
                                    <a href= "https://github.com/inbox" class= "unread_count new js-inbox-count" >1</a>
                                    </li>
                                    <li><a href= "https://github.com/account" >Account Settings</a></li>
                                    <li><a href= "/logout" >Log Out</a></li>
                                    </ul>
                                    </div><!--/.userbox -->




                                    <div class= "topsearch" >

                                    <form action= "/search" id= "top_search_form" method= "get" >
                                    <a href= "/search" class= "advanced-search tooltipped downwards" title= "Advanced Search" >Advanced Search</a>
                                    <input type= "search" class= "search my_repos_autocompleter" name= "q" results= "5" placeholder= "Search&hellip;" / > <input type= "submit" value= "Search" class= "button" / >
                                    <input type= "hidden" name= "type" value= "Everything" / >
                                    <input type= "hidden" name= "repo" value= "" / >
                                    <input type= "hidden" name= "langOverride" value= "" / >
                                    <input type= "hidden" name= "start_value" value= "1" / >
                                    </form>
                                    <ul class= "nav" >
                                    <li><a href= "/explore" >Explore GitHub</a></li>
                                    <li><a href= "https://gist.github.com" >Gist</a></li>
                                    <li><a href= "/blog" >Blog</a></li>
                                    <li><a href= "http://help.github.com" >Help</a></li>
                                    </ul>

                                    </div>

                                    </div>




                                    <div class= "site" >
                                    <div class= "pagehead repohead vis-public   " >



                                    <div class= "title-actions-bar" >
                                    <h1>
                                    <a href= "/marick" >marick</a> / <strong><a href= "https://github.com/marick/Midje" >Midje</a></strong>


                                    </h1>


                                    <ul class= "actions" >



                                    <li class= "for-owner" style= "display:none" ><a href= "https://github.com/marick/Midje/admin" class= "minibutton btn-admin " ><span><span class= "icon" ></span>Admin</span></a></li>
                                    <li>
                                    <a href= "/marick/Midje/toggle_watch" class= "minibutton btn-watch " id= "watch_button" onclick= "var f = document.createElement('form'); f.style.display = 'none'; this.parentNode.appendChild(f); f.method = 'POST'; f.action = this.href;var s = document.createElement('input'); s.setAttribute('type', 'hidden'); s.setAttribute('name', 'authenticity_token'); s.setAttribute('value', '8b0f79f3092962caf62c42a6a0e8aad5c5545a08'); f.appendChild(s);f.submit();return false;" style= "display:none" ><span><span class= "icon" ></span>Watch</span></a>
                                    <a href= "/marick/Midje/toggle_watch" class= "minibutton btn-watch " id= "unwatch_button" onclick= "var f = document.createElement('form'); f.style.display = 'none'; this.parentNode.appendChild(f); f.method = 'POST'; f.action = this.href;var s = document.createElement('input'); s.setAttribute('type', 'hidden'); s.setAttribute('name', 'authenticity_token'); s.setAttribute('value', '8b0f79f3092962caf62c42a6a0e8aad5c5545a08'); f.appendChild(s);f.submit();return false;" style= "display:none" ><span><span class= "icon" ></span>Unwatch</span></a>
                                    </li>


                                    <li class= "for-notforked" ><a href= "#fork_box" class= "minibutton btn-fork " rel= "facebox" ><span><span class= "icon" ></span>Fork</span></a></li>


                                    <div id= "fork_box" style= "display:none" >
                                    <h2>Where do you want to fork this to?</h2>

                                    <div class= "full-button" >
                                    <form action= "/marick/Midje/fork" method= "post" ><div style= "margin:0;padding:0" ><input name= "authenticity_token" type= "hidden" value= "8b0f79f3092962caf62c42a6a0e8aad5c5545a08" / ></div>
                                    <button class= "classy" ><span>Fork to AlexBaranosky</span></button>
                                    </form>
                                    </div>


                                    <div class= "rule" ></div>

                                    <div class= "full-button" >
                                    <form action= "/marick/Midje/fork" method= "post" ><div style= "margin:0;padding:0" ><input name= "authenticity_token" type= "hidden" value= "8b0f79f3092962caf62c42a6a0e8aad5c5545a08" / ></div>
                                    <input id= "organization" name= "organization" type= "hidden" value= "cyrusinnovation" / >
                                    <button class= "classy" ><span>Fork to cyrusinnovation (organization) </span></button>
                                    </form>
                                    </div>


                                    </div>


                                    <li id= 'pull_request_item 'class= 'nspr 'style= 'display:none '><a href= "/marick/Midje/pull/new/master" class= "minibutton btn-pull-request " ><span><span class= "icon" ></span>Pull Request</span></a></li>



                                    <li class= "repostats" >
                                    <ul class= "repo-stats" >
                                    <li class= "watchers" ><a href= "/marick/Midje/watchers" title= "Watchers" class= "tooltipped downwards" >73</a></li>
                                    <li class= "forks" ><a href= "/marick/Midje/network" title= "Forks" class= "tooltipped downwards" >6</a></li>
                                    </ul>
                                    </li>
                                    </ul>

                                    </div>


                                    <ul class= "tabs" >
                                    <li><a href= "https://github.com/marick/Midje" class= "selected" highlight= "repo_source" >Source</a></li>
                                    <li><a href= "https://github.com/marick/Midje/commits/master" highlight= "repo_commits" >Commits</a></li>
                                    <li><a href= "/marick/Midje/network" highlight= "repo_network" >Network</a></li>
                                    <li><a href= "/marick/Midje/pulls" highlight= "repo_pulls" >Pull Requests (0) </a></li>





                                    <li><a href= "/marick/Midje/issues" highlight= "issues" >Issues (9) </a></li>


                                    <li><a href= "/marick/Midje/wiki" highlight= "repo_wiki" >Wiki (28) </a></li>

                                    <li><a href= "/marick/Midje/graphs" highlight= "repo_graphs" >Graphs</a></li>

                                    <li class= "contextswitch nochoices" >
                                    <span class= "toggle leftwards" >
                                    <em>Branch:</em>
                                    <code>master</code>
                                    </span>
                                    </li>
                                    </ul>

                                    <div style= "display:none" id= "pl-description" ><p><em class= "placeholder" >click here to add a description</em></p></div>
                                    <div style= "display:none" id= "pl-homepage" ><p><em class= "placeholder" >click here to add a homepage</em></p></div>

                                    <div class= "subnav-bar" >

                                    <ul>
                                    <li>
                                    <a href= "#" class= "dropdown" >Switch Branches (2) </a>
                                    <ul>



                                    <li><a href= "/marick/Midje/blob/0.9/leiningen/midje.clj" action= "show" >0.9</a></li>



                                    <li><strong>master &# x2713 ;</strong></li>

                                    </ul>
                                    </li>
                                    <li>
                                    <a href= "#" class= "dropdown " >Switch Tags (15) </a>
                                    <ul>

                                    <li><a href= "/marick/Midje/blob/v.0.9.0RC1/leiningen/midje.clj" >v.0.9.0RC1</a></li>


                                    <li><a href= "/marick/Midje/blob/v.0.9.0/leiningen/midje.clj" >v.0.9.0</a></li>


                                    <li><a href= "/marick/Midje/blob/v.0.8.1/leiningen/midje.clj" >v.0.8.1</a></li>


                                    <li><a href= "/marick/Midje/blob/v.0.8.0/leiningen/midje.clj" >v.0.8.0</a></li>


                                    <li><a href= "/marick/Midje/blob/v.0.7.2/leiningen/midje.clj" >v.0.7.2</a></li>


                                    <li><a href= "/marick/Midje/blob/v.0.7.1/leiningen/midje.clj" >v.0.7.1</a></li>


                                    <li><a href= "/marick/Midje/blob/v.0.7.0/leiningen/midje.clj" >v.0.7.0</a></li>


                                    <li><a href= "/marick/Midje/blob/v.0.6.1/leiningen/midje.clj" >v.0.6.1</a></li>


                                    <li><a href= "/marick/Midje/blob/v.0.6.0/leiningen/midje.clj" >v.0.6.0</a></li>


                                    <li><a href= "/marick/Midje/blob/v.0.5.0/leiningen/midje.clj" >v.0.5.0</a></li>


                                    <li><a href= "/marick/Midje/blob/v.0.4.0/leiningen/midje.clj" >v.0.4.0</a></li>


                                    <li><a href= "/marick/Midje/blob/v.0.3.0/leiningen/midje.clj" >v.0.3.0</a></li>


                                    <li><a href= "/marick/Midje/blob/v.0.2.0/leiningen/midje.clj" >v.0.2.0</a></li>


                                    <li><a href= "/marick/Midje/blob/v.0.1.1/leiningen/midje.clj" >v.0.1.1</a></li>


                                    <li><a href= "/marick/Midje/blob/midje-0.5.0/leiningen/midje.clj" >midje-0.5.0</a></li>

                                    </ul>

                                    </li>
                                    <li>

                                    <a href= "/marick/Midje/branches" class= "manage" >Branch List</a>

                                    </li>
                                    </ul>
                                    </div>











                                    <div id= "repo_details" class= "metabox clearfix" >
                                    <div id= "repo_details_loader" class= "metabox-loader" style= "display:none" >Sending Request&hellip ;</div>

                                    <a href= "/marick/Midje/downloads" class= "download-source" id= "download_button" title= "Download source, tagged packages and binaries." ><span class= "icon" ></span>Downloads</a>

                                    <div id= "repository_desc_wrapper" >
                                    <div id= "repository_description" rel= "repository_description_edit" >

                                    <p>Midje provides a migration path from clojure.test to a more flexible, readable, abstract, and gracious style of testing
                                    <span id= "read_more" style= "display:none" >&mdash ; <a href="#readme">Read more</a></span>
                                    </p>

                                    </div>

                                    <div id= "repository_description_edit" style= "display:none;" class= "inline-edit" >
                                    <form action= "/marick/Midje/admin/update" method= "post" ><div style= "margin:0;padding:0" ><input name= "authenticity_token" type= "hidden" value= "8b0f79f3092962caf62c42a6a0e8aad5c5545a08" / ></div>
                                    <input type= "hidden" name= "field" value= "repository_description" >
                                    <input type= "text" class= "textfield" name= "value" value= "Midje provides a migration path from clojure.test to a more flexible, readable, abstract, and gracious style of testing" >
                                    <div class= "form-actions" >
                                    <button class= "minibutton" ><span>Save</span></button> &nbsp ; <a href="#" class="cancel">Cancel</a>
                                    </div>
                                    </form>
                                    </div>


                                    <div class= "repository-homepage" id= "repository_homepage" rel= "repository_homepage_edit" >
                                    <p><a href= "http://" rel= "nofollow" ></a></p>
                                    </div>

                                    <div id= "repository_homepage_edit" style= "display:none;" class= "inline-edit" >
                                    <form action= "/marick/Midje/admin/update" method= "post" ><div style= "margin:0;padding:0" ><input name= "authenticity_token" type= "hidden" value= "8b0f79f3092962caf62c42a6a0e8aad5c5545a08" / ></div>
                                    <input type= "hidden" name= "field" value= "repository_homepage" >
                                    <input type= "text" class= "textfield" name= "value" value= "" >
                                    <div class= "form-actions" >
                                    <button class= "minibutton" ><span>Save</span></button> &nbsp ; <a href="#" class="cancel">Cancel</a>
                                    </div>
                                    </form>
                                    </div>
                                    </div>
                                    <div class= "rule " ></div>
                                    <div id= "url_box" class= "url-box" >
                                    <ul class= "clone-urls" >


                                    <li id= "http_clone_url" ><a href= "https://github.com/marick/Midje.git" data-permissions= "Read-Only" >HTTP</a></li>
                                    <li id= "public_clone_url" ><a href= "git://github.com/marick/Midje.git" data-permissions= "Read-Only" >Git Read-Only</a></li>


                                    </ul>
                                    <input type= "text" spellcheck= "false" id= "url_field" class= "url-field" / >
                                    <span style= "display:none" id= "url_box_clippy" ></span>
                                    <span id= "clippy_tooltip_url_box_clippy" class= "clippy-tooltip tooltipped" title= "copy to clipboard" >
                                    <object classid= "clsid:d27cdb6e-ae6d-11cf-96b8-444553540000"
                                    width= "14"
                                    height= "14"
                                    class= "clippy"
                                    id= "clippy" >
                                    <param name= "movie" value= "https://assets3.github.com/flash/clippy.swf?v5" / >
                                    <param name= "allowScriptAccess" value= "always" / >
                                    <param name= "quality" value= "high" / >
                                    <param name= "scale" value= "noscale" / >
                                    <param NAME= "FlashVars" value= "id=url_box_clippy&amp;copied=&amp;copyto=" >
                                    <param name= "bgcolor" value= "#FFFFFF" >
                                    <param name= "wmode" value= "opaque" >
                                    <embed src= "https://assets3.github.com/flash/clippy.swf?v5"
                                    width= "14"
                                    height= "14"
                                    name= "clippy"
                                    quality= "high"
                                    allowScriptAccess= "always"
                                    type= "application/x-shockwave-flash"
                                    pluginspage= "http://www.macromedia.com/go/getflashplayer"
                                    FlashVars= "id=url_box_clippy&amp;copied=&amp;copyto="
                                    bgcolor= "#FFFFFF"
                                    wmode= "opaque"
                                    / >
                                    </object>
                                    </span>

                                    <p id= "url_description" >This URL has <strong>Read+Write</strong> access</p>
                                    </div>
                                    </div>




                                    </div><!--/.pagehead -->











                                    <script type= "text/javascript" >
                                    GitHub.currentCommitRef = 'master 'GitHub.currentRepoOwner = 'marick 'GitHub.currentRepo = "Midje"
                                    GitHub.downloadRepo = '/ marick/Midje/archives/master 'GitHub.revType = "master"

                                    GitHub.controllerName = "blob"
                                    GitHub.actionName = "show"
                                    GitHub.currentAction = "blob#show"


                                    GitHub.hasWriteAccess = false
                                    GitHub.hasAdminAccess = false
                                    GitHub.watchingRepo = true
                                    GitHub.ignoredRepo = false
                                    GitHub.hasForkOfRepo = ""
                                    GitHub.hasForked = false



                                    </script>








                                    <div id= "commit" >
                                    <div class= "group" >

                                    <div class= "envelope commit" >
                                    <div class= "human" >

                                    <div class= "message" ><pre><a href= "/marick/Midje/commit/ee953144be3dddf4209655eacd4c7f475858de10" >Bugfix: inline chatty checkers didn 't record intermediate results.</a> </pre></div>


                                    <div class= "actor" >
                                    <div class= "gravatar" >

                                    <img src= "https://secure.gravatar.com/avatar/a523012f661f603806ab1c22d855216f?s=140&d=https%3A%2F%2Fgithub.com%2Fimages%2Fgravatars%2Fgravatar-140.png" alt= "" width= "30" height= "30" / >
                                    </div>
                                    <div class= "name" ><a href= "/marick" >marick</a> <span> (author) </span></div>
                                    <div class= "date" >
                                    <abbr class= "relatize" title= "2011-01-07 14:43:08" >Fri Jan 07 14 : 43 : 08 -0800 2011 </abbr>
                                    </div>
                                    </div>



                                    </div>
                                    <div class= "machine" >
                                    <span>c</span>ommit&nbsp ;&nbsp;<a href="/marick/Midje/commit/ee953144be3dddf4209655eacd4c7f475858de10" hotkey="c">ee953144be3dddf42096</a><br />
                                    <span>t</span>ree&nbsp ;&nbsp;&nbsp;&nbsp;<a href="/marick/Midje/tree/ee953144be3dddf4209655eacd4c7f475858de10" hotkey="t">24471fe742a96648f505</a><br />

                                    <span>p</span>arent&nbsp ;

                                    <a href= "/marick/Midje/tree/36744be9e0ce0648990c13f303c826d3567e1a7c" hotkey= "p" >36744be9e0ce0648990c</a>


                                    </div>
                                    </div>

                                    </div>
                                    </div>



                                    <div id= "slider" >


                                    <div class= "breadcrumb" data-path= "leiningen/midje.clj/" >
                                    <b><a href= "/marick/Midje/tree/558482f798889c98b48baebcf4512e904152d2aa" >Midje</a></b> / <a href= "/marick/Midje/tree/558482f798889c98b48baebcf4512e904152d2aa/leiningen" >leiningen</a> / midje.clj <span style= "display:none" id= "clippy_994" >leiningen/midje.clj</span>

                                    <object classid= "clsid:d27cdb6e-ae6d-11cf-96b8-444553540000"
                                    width= "110"
                                    height= "14"
                                    class= "clippy"
                                    id= "clippy" >
                                    <param name= "movie" value= "https://assets3.github.com/flash/clippy.swf?v5" / >
                                    <param name= "allowScriptAccess" value= "always" / >
                                    <param name= "quality" value= "high" / >
                                    <param name= "scale" value= "noscale" / >
                                    <param NAME= "FlashVars" value= "id=clippy_994&amp;copied=copied!&amp;copyto=copy to clipboard" >
                                    <param name= "bgcolor" value= "#FFFFFF" >
                                    <param name= "wmode" value= "opaque" >
                                    <embed src= "https://assets3.github.com/flash/clippy.swf?v5"
                                    width= "110"
                                    height= "14"
                                    name= "clippy"
                                    quality= "high"
                                    allowScriptAccess= "always"
                                    type= "application/x-shockwave-flash"
                                    pluginspage= "http://www.macromedia.com/go/getflashplayer"
                                    FlashVars= "id=clippy_994&amp;copied=copied!&amp;copyto=copy to clipboard"
                                    bgcolor= "#FFFFFF"
                                    wmode= "opaque"
                                    / >
                                    </object>


                                    </div>

                                    <div class= "frames" >
                                    <div class= "frame frame-center" data-path= "leiningen/midje.clj/" >
                                    <div id= "files" >
                                    <div class= "file" >
                                    <div class= "meta" >
                                    <div class= "info" >
                                    <span class= "icon" ><img alt= "Txt" height= "16" src= "https://assets0.github.com/images/icons/txt.png?bcc3b3077c0d5984298fabdd136ee99050a07983" width= "16" / ></span>
                                    <span class= "mode" title= "File Mode" >100644</span>

                                    <span>31 lines (28 sloc) </span>

                                    <span>1.297 kb</span>
                                    </div>
                                    <ul class= "actions" >

                                    <li><a class= "file-edit-link" href= "#" rel= "/marick/Midje/file-edit/__ref__/leiningen/midje.clj" >edit</a></li>

                                    <li><a href= "/marick/Midje/raw/master/leiningen/midje.clj" id= "raw-url" >raw</a></li>

                                    <li><a href= "/marick/Midje/blame/master/leiningen/midje.clj" >blame</a></li>

                                    <li><a href= "/marick/Midje/commits/master/leiningen/midje.clj" >history</a></li>
                                    </ul>
                                    </div>

                                    <div class= "data type-clojure" >

                                    <table cellpadding= "0" cellspacing= "0" >
                                    <tr>
                                    <td>
                                    <pre class= "line_numbers" ><span id= "LID1" rel= "#L1" >1</span>
                                    <span id= "LID2" rel= "#L2" >2</span>
                                    <span id= "LID3" rel= "#L3" >3</span>
                                    <span id= "LID4" rel= "#L4" >4</span>
                                    <span id= "LID5" rel= "#L5" >5</span>
                                    <span id= "LID6" rel= "#L6" >6</span>
                                    <span id= "LID7" rel= "#L7" >7</span>
                                    <span id= "LID8" rel= "#L8" >8</span>
                                    <span id= "LID9" rel= "#L9" >9</span>
                                    <span id= "LID10" rel= "#L10" >10</span>
                                    <span id= "LID11" rel= "#L11" >11</span>
                                    <span id= "LID12" rel= "#L12" >12</span>
                                    <span id= "LID13" rel= "#L13" >13</span>
                                    <span id= "LID14" rel= "#L14" >14</span>
                                    <span id= "LID15" rel= "#L15" >15</span>
                                    <span id= "LID16" rel= "#L16" >16</span>
                                    <span id= "LID17" rel= "#L17" >17</span>
                                    <span id= "LID18" rel= "#L18" >18</span>
                                    <span id= "LID19" rel= "#L19" >19</span>
                                    <span id= "LID20" rel= "#L20" >20</span>
                                    <span id= "LID21" rel= "#L21" >21</span>
                                    <span id= "LID22" rel= "#L22" >22</span>
                                    <span id= "LID23" rel= "#L23" >23</span>
                                    <span id= "LID24" rel= "#L24" >24</span>
                                    <span id= "LID25" rel= "#L25" >25</span>
                                    <span id= "LID26" rel= "#L26" >26</span>
                                    <span id= "LID27" rel= "#L27" >27</span>
                                    <span id= "LID28" rel= "#L28" >28</span>
                                    <span id= "LID29" rel= "#L29" >29</span>
                                    <span id= "LID30" rel= "#L30" >30</span>
                                    <span id= "LID31" rel= "#L31" >31</span>
                                    </pre>
                                    </td>
                                    <td width= "100%" >


                                    <div class= "highlight" ><pre><div class= 'line 'id= 'LC1 '><span class= "p" > (</span><span class= "nf" >ns</span> <span class= "nv" >leiningen</span><span class= "o" >.</span><span class= "nv" >midje</span></div><div class= 'line 'id= 'LC2 '>&nbsp ;&nbsp;<span class="p">(</span><span class="nf">:use</span> <span class="p">[</span><span class="nv">leiningen</span><span class="o">.</span><span class="nv">util</span><span class="o">.</span><span class="nv">ns</span> <span class="nv">:only</span> <span class="p">[</span><span class="nv">namespaces-in-dir</span><span class="p">]]</span></div><div class='line' id='LC3'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">[</span><span class="nv">leiningen</span><span class="o">.</span><span class="nv">compile</span> <span class="nv">:only</span> <span class="p">[</span><span class="nv">eval-in-project</span><span class="p">]]))</span></div><div class='line' id='LC4'><br/></div><div class='line' id='LC5'><span class="p">(</span><span class="k">defn </span><span class="nv">require-namespaces-form</span> <span class="p">[</span><span class="nv">namespaces</span><span class="p">]</span></div><div class='line' id='LC6'>&nbsp;&nbsp;<span class="o">`</span><span class="p">(</span><span class="nf">do</span></div><div class='line' id='LC7'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">(</span><span class="nf">require</span> <span class="ss">&#39;clojure</span><span class="o">.</span><span class="nv">test</span><span class="p">)</span></div><div class='line' id='LC8'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">(</span><span class="nf">alter-var-root</span> <span class="p">(</span><span class="nf">var</span> <span class="nv">clojure</span><span class="o">.</span><span class="nv">test/*report-counters*</span><span class="p">)</span></div><div class='line' id='LC9'>		     <span class="p">(</span><span class="k">fn </span><span class="p">[</span><span class="nv">_</span><span class="o">#</span><span class="p">]</span> <span class="p">(</span><span class="nb">ref </span><span class="nv">clojure</span><span class="o">.</span><span class="nv">test/*initial-report-counters*</span><span class="p">)))</span></div><div class='line' id='LC10'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">(</span><span class="nb">doseq </span><span class="p">[</span><span class="nv">n</span><span class="o">#</span> <span class="ss">&#39;~namespaces</span><span class="p">]</span> <span class="p">(</span><span class="nf">require</span> <span class="nv">n</span><span class="o">#</span><span class="p">))</span></div><div class='line' id='LC11'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">(</span><span class="k">let </span><span class="p">[</span><span class="nv">passes</span><span class="o">#</span> <span class="p">(</span><span class="nf">:pass</span> <span class="nv">@clojure</span><span class="o">.</span><span class="nv">test/*report-counters*</span><span class="p">)</span></div><div class='line' id='LC12'>	   <span class="nv">fails</span><span class="o">#</span> <span class="p">(</span><span class="nf">:fail</span> <span class="nv">@clojure</span><span class="o">.</span><span class="nv">test/*report-counters*</span><span class="p">)</span></div><div class='line' id='LC13'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nv">failure-message</span><span class="o">#</span> <span class="p">(</span><span class="nf">condp</span> <span class="nv">=</span> <span class="nv">fails</span><span class="o">#</span></div><div class='line' id='LC14'>			       <span class="mi">0</span> <span class="p">(</span><span class="nf">format</span> <span class="s">&quot;All claimed facts (%d) have been confirmed.&quot;</span> <span class="nv">passes</span><span class="o">#</span><span class="p">)</span></div><div class='line' id='LC15'>			       <span class="mi">1</span> <span class="p">(</span><span class="nf">format</span> <span class="s">&quot;FAILURE: %d fact was not confirmed.&quot;</span> <span class="nv">fails</span><span class="o">#</span><span class="p">)</span></div><div class='line' id='LC16'>			       <span class="p">(</span><span class="nf">format</span> <span class="s">&quot;FAILURE: %d facts were not confirmed.&quot;</span> <span class="nv">fails</span><span class="o">#</span><span class="p">))</span></div><div class='line' id='LC17'>	   <span class="nv">potential-consolation</span><span class="o">#</span> <span class="p">(</span><span class="nf">condp</span> <span class="nv">=</span> <span class="nv">passes</span><span class="o">#</span></div><div class='line' id='LC18'>				      <span class="mi">0</span> <span class="s">&quot;&quot;</span></div><div class='line' id='LC19'>				      <span class="mi">1</span> <span class="s">&quot;(But 1 was.)&quot;</span></div><div class='line' id='LC20'>				      <span class="p">(</span><span class="nf">format</span> <span class="s">&quot;(But %d were.)&quot;</span> <span class="nv">passes</span><span class="o">#</span><span class="p">))</span></div><div class='line' id='LC21'>	   <span class="nv">consolation</span><span class="o">#</span> <span class="p">(</span><span class="k">if </span><span class="p">(</span><span class="nb">&gt; </span><span class="nv">fails</span><span class="o">#</span> <span class="mi">0</span><span class="p">)</span> <span class="nv">potential-consolation</span><span class="o">#</span> <span class="s">&quot;&quot;</span><span class="p">)]</span></div><div class='line' id='LC22'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">(</span><span class="nb">println </span><span class="nv">failure-message</span><span class="o">#</span> <span class="nv">consolation</span><span class="o">#</span><span class="p">))))</span></div><div class='line' id='LC23'><br/></div><div class='line' id='LC24'><span class="p">(</span><span class="k">defn </span><span class="nv">midje</span> <span class="p">[</span><span class="nv">project</span> <span class="nv">&amp;</span> <span class="nv">namespaces</span><span class="p">]</span></div><div class='line' id='LC25'>&nbsp;&nbsp;<span class="p">(</span><span class="k">let </span><span class="p">[</span><span class="nv">desired-namespaces</span>  <span class="p">(</span><span class="k">if </span><span class="p">(</span><span class="nf">empty?</span> <span class="nv">namespaces</span><span class="p">)</span></div><div class='line' id='LC26'>			      <span class="p">(</span><span class="nb">concat </span><span class="p">(</span><span class="nf">namespaces-in-dir</span> <span class="p">(</span><span class="nf">:test-path</span> <span class="nv">project</span><span class="p">))</span></div><div class='line' id='LC27'>				      <span class="p">(</span><span class="nf">namespaces-in-dir</span> <span class="p">(</span><span class="nf">:source-path</span> <span class="nv">project</span><span class="p">)))</span></div><div class='line' id='LC28'>			      <span class="p">(</span><span class="nb">map </span><span class="nv">symbol</span> <span class="nv">namespaces</span><span class="p">))]</span></div><div class='line' id='LC29'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">(</span><span class="nf">eval-in-project</span> <span class="nv">project</span></div><div class='line' id='LC30'>		     <span class="p">(</span><span class="nf">require-namespaces-form</span> <span class="nv">desired-namespaces</span><span class="p">))))</span></div><div class='line' id='LC31'><br/></div></pre></div>


                                      </td>
                                      </tr>
                                      </table>

                                      </div>


                                      </div>
                                      </div>
                                      </div>
                                      </div>


                                      </div>



                                      <div class= "frame frame-loading" style= "display:none;" >
                                      <img src= "/images/modules/ajax/big_spinner_336699.gif" >
                                      </div>
                                      </div>


                                      </div>

                                      <div id= "footer" class= "clearfix" >
                                      <div class= "site" >
                                      <div class= "sponsor" >
                                      <a href= "http://www.rackspace.com" class= "logo" >
                                      <img alt= "Dedicated Server" src= "https://assets1.github.com/images/modules/footer/rackspace_logo.png?v2?bcc3b3077c0d5984298fabdd136ee99050a07983" / >
                                      </a>
                                      Powered by the <a href= "http://www.rackspace.com " >Dedicated
                                      Servers</a> and<br/> <a href= "http://www.rackspacecloud.com" >Cloud
                                      Computing</a> of Rackspace Hosting<span>&reg ;</span>
                                      </div>

                                      <ul class= "links" >
                                      <li class= "blog" ><a href= "https://github.com/blog" >Blog</a></li>
                                      <li><a href= "http://support.github.com?sso=Z_ljhlotGAqY31J2PxuR1ckFHfK5D-vMslAEuqKvZzrpLIuhWj_BwFfjaqZE5zZ1EY5BlaDkeOdCj9aBRv9k6VVfOOlnYhjL6JgKfJG03dcI8FJxXiDxogg0x3LFUQtEuNb1kjTZmKi9zNS44f7HfJyOva7il54JdLb4XUx-IISaomHM2gYeYmIna5gJTeQ8L3q4T9pW04RTAezZzHLZeqHsllaX_DfgS67Q5ipLLoxIMk0kiUmiG9FYxC-zYQ_Y" >Support</a></li>
                                      <li><a href= "https://github.com/training" >Training</a></li>
                                      <li><a href= "http://jobs.github.com" >Job Board</a></li>
                                      <li><a href= "http://shop.github.com" >Shop</a></li>
                                      <li><a href= "https://github.com/contact" >Contact</a></li>
                                      <li><a href= "http://develop.github.com" >API</a></li>
                                      <li><a href= "http://status.github.com" >Status</a></li>
                                      </ul>
                                      <ul class= "sosueme" >
                                      <li class= "main" >&copy ; 2011 <span id="_rrt" title="1.39212s from fe5.rs.github.com">GitHub</span> Inc. All rights reserved.</li>
                                      <li><a href= "/site/terms" >Terms of Service</a></li>
                                      <li><a href= "/site/privacy" >Privacy</a></li>
                                      <li><a href= "https://github.com/security" >Security</a></li>
                                      </ul>
                                      </div>
                                      </div><!--/# footer -->




                                      <!-- current locale: -->
                                      <div class= "locales" >
                                      <div class= "site" >

                                      <ul class= "choices clearfix limited-locales" >
                                      <li><span class= "current" >English</span></li>

                                      <li><a rel= "nofollow" href= "?locale=de" >Deutsch</a></li>

                                      <li><a rel= "nofollow" href= "?locale=fr" >Fran ç ais</a></li>

                                      <li><a rel= "nofollow" href= "?locale=ja" > 日 本 語 </a></li>

                                      <li><a rel= "nofollow" href= "?locale=pt-BR" >Portugu ê s (BR) </a></li>

                                      <li><a rel= "nofollow" href= "?locale=ru" > Р у с с к и й </a></li>

                                      <li><a rel= "nofollow" href= "?locale=zh" > 中 文 </a></li>

                                      <li class= "all" ><a href= "#" class= "minibutton btn-forward js-all-locales" ><span><span class= "icon" ></span>See all available languages</span></a></li>
                                      </ul>

                                      <div class= "all-locales clearfix" >
                                      <h3>Your current locale selection: <strong>English</strong>. Choose another?</h3>


                                      <ul class= "choices" >

                                      <li><a rel= "nofollow" href= "?locale=en" >English</a></li>

                                      <li><a rel= "nofollow" href= "?locale=af" >Afrikaans</a></li>

                                      <li><a rel= "nofollow" href= "?locale=ca" >Catal à </a></li>

                                      <li><a rel= "nofollow" href= "?locale=cs" > Č e š tina</a></li>

                                      </ul>

                                      <ul class= "choices" >

                                      <li><a rel= "nofollow" href= "?locale=de" >Deutsch</a></li>

                                      <li><a rel= "nofollow" href= "?locale=es" >Espa ñ ol</a></li>

                                      <li><a rel= "nofollow" href= "?locale=fr" >Fran ç ais</a></li>

                                      <li><a rel= "nofollow" href= "?locale=hr" >Hrvatski</a></li>

                                      </ul>

                                      <ul class= "choices" >

                                      <li><a rel= "nofollow" href= "?locale=id" >Indonesia</a></li>

                                      <li><a rel= "nofollow" href= "?locale=it" >Italiano</a></li>

                                      <li><a rel= "nofollow" href= "?locale=ja" > 日 本 語 </a></li>

                                      <li><a rel= "nofollow" href= "?locale=nl" >Nederlands</a></li>

                                      </ul>

                                      <ul class= "choices" >

                                      <li><a rel= "nofollow" href= "?locale=no" >Norsk</a></li>

                                      <li><a rel= "nofollow" href= "?locale=pl" >Polski</a></li>

                                      <li><a rel= "nofollow" href= "?locale=pt-BR" >Portugu ê s (BR) </a></li>

                                      <li><a rel= "nofollow" href= "?locale=ru" > Р у с с к и й </a></li>

                                      </ul>

                                      <ul class= "choices" >

                                      <li><a rel= "nofollow" href= "?locale=sr" > С р п с к и </a></li>

                                      <li><a rel= "nofollow" href= "?locale=sv" >Svenska</a></li>

                                      <li><a rel= "nofollow" href= "?locale=zh" > 中 文 </a></li>

                                      </ul>

                                      </div>

                                      </div>
                                      <div class= "fade" ></div>
                                      </div>



                                      <script>window._auth_token = "8b0f79f3092962caf62c42a6a0e8aad5c5545a08" </script>
                                      <div id= "keyboard_shortcuts_pane" style= "display:none" >
                                      <h2>Keyboard Shortcuts</h2>

                                      <div class= "columns threecols" >
                                      <div class= "column first" >
                                      <h3>Site wide shortcuts</h3>
                                      <dl class= "keyboard-mappings" >
                                      <dt>s</dt>
                                      <dd>Focus site search</dd>
                                      </dl>
                                      <dl class= "keyboard-mappings" >
                                      <dt>?</dt>
                                      <dd>Bring up this help dialog</dd>
                                      </dl>
                                      </div><!--/.column.first -->
                                      <div class= "column middle" >
                                      <h3>Commit list</h3>
                                      <dl class= "keyboard-mappings" >
                                      <dt>j</dt>
                                      <dd>Move selected down</dd>
                                      </dl>
                                      <dl class= "keyboard-mappings" >
                                      <dt>k</dt>
                                      <dd>Move selected up</dd>
                                      </dl>
                                      <dl class= "keyboard-mappings" >
                                      <dt>t</dt>
                                      <dd>Open tree</dd>
                                      </dl>
                                      <dl class= "keyboard-mappings" >
                                      <dt>p</dt>
                                      <dd>Open parent</dd>
                                      </dl>
                                      <dl class= "keyboard-mappings" >
                                      <dt>c <em>or</em> o <em>or</em> enter</dt>
                                      <dd>Open commit</dd>
                                      </dl>
                                      </div><!--/.column.first -->
                                      <div class= "column last" >
                                      <h3>Pull request list</h3>
                                      <dl class= "keyboard-mappings" >
                                      <dt>j</dt>
                                      <dd>Move selected down</dd>
                                      </dl>
                                      <dl class= "keyboard-mappings" >
                                      <dt>k</dt>
                                      <dd>Move selected up</dd>
                                      </dl>
                                      <dl class= "keyboard-mappings" >
                                      <dt>o <em>or</em> enter</dt>
                                      <dd>Open issue</dd>
                                      </dl>
                                      </div><!--/.columns.last -->
                                      </div><!--/.columns.equacols -->

                                      <div class= "rule" ></div>

                                      <h3>Issues</h3>

                                      <div class= "columns threecols" >
                                      <div class= "column first" >
                                      <dl class= "keyboard-mappings" >
                                      <dt>j</dt>
                                      <dd>Move selected down</dd>
                                      </dl>
                                      <dl class= "keyboard-mappings" >
                                      <dt>k</dt>
                                      <dd>Move selected up</dd>
                                      </dl>
                                      <dl class= "keyboard-mappings" >
                                      <dt>x</dt>
                                      <dd>Toggle select target</dd>
                                      </dl>
                                      <dl class= "keyboard-mappings" >
                                      <dt>o <em>or</em> enter</dt>
                                      <dd>Open issue</dd>
                                      </dl>
                                      </div><!--/.column.first -->
                                      <div class= "column middle" >
                                      <dl class= "keyboard-mappings" >
                                      <dt>I</dt>
                                      <dd>Mark selected as read</dd>
                                      </dl>
                                      <dl class= "keyboard-mappings" >
                                      <dt>U</dt>
                                      <dd>Mark selected as unread</dd>
                                      </dl>
                                      <dl class= "keyboard-mappings" >
                                      <dt>e</dt>
                                      <dd>Close selected</dd>
                                      </dl>
                                      <dl class= "keyboard-mappings" >
                                      <dt>y</dt>
                                      <dd>Remove selected from view</dd>
                                      </dl>
                                      </div><!--/.column.middle -->
                                      <div class= "column last" >
                                      <dl class= "keyboard-mappings" >
                                      <dt>c</dt>
                                      <dd>Create issue</dd>
                                      </dl>
                                      <dl class= "keyboard-mappings" >
                                      <dt>l</dt>
                                      <dd>Create label</dd>
                                      </dl>
                                      <dl class= "keyboard-mappings" >
                                      <dt>i</dt>
                                      <dd>Back to inbox</dd>
                                      </dl>
                                      <dl class= "keyboard-mappings" >
                                      <dt>u</dt>
                                      <dd>Back to issues</dd>
                                      </dl>
                                      <dl class= "keyboard-mappings" >
                                      <dt>/</dt>
                                      <dd>Focus issues search</dd>
                                      </dl>
                                      </div>
                                      </div>

                                      <div class= "rule" ></div>

                                      <h3>Network Graph</h3>
                                      <div class= "columns equacols" >
                                      <div class= "column first" >
                                      <dl class= "keyboard-mappings" >
                                      <dt> ← <em>or</em> h</dt>
                                      <dd>Scroll left</dd>
                                      </dl>
                                      <dl class= "keyboard-mappings" >
                                      <dt> → <em>or</em> l</dt>
                                      <dd>Scroll right</dd>
                                      </dl>
                                      <dl class= "keyboard-mappings" >
                                      <dt> ↑ <em>or</em> k</dt>
                                      <dd>Scroll up</dd>
                                      </dl>
                                      <dl class= "keyboard-mappings" >
                                      <dt> ↓ <em>or</em> j</dt>
                                      <dd>Scroll down</dd>
                                      </dl>
                                      <dl class= "keyboard-mappings" >
                                      <dt>t</dt>
                                      <dd>Toggle visibility of head labels</dd>
                                      </dl>
                                      </div><!--/.column.first -->
                                      <div class= "column last" >
                                      <dl class= "keyboard-mappings" >
                                      <dt>shift ← <em>or</em> shift h</dt>
                                      <dd>Scroll all the way left</dd>
                                      </dl>
                                      <dl class= "keyboard-mappings" >
                                      <dt>shift → <em>or</em> shift l</dt>
                                      <dd>Scroll all the way right</dd>
                                      </dl>
                                      <dl class= "keyboard-mappings" >
                                      <dt>shift ↑ <em>or</em> shift k</dt>
                                      <dd>Scroll all the way up</dd>
                                      </dl>
                                      <dl class= "keyboard-mappings" >
                                      <dt>shift ↓ <em>or</em> shift j</dt>
                                      <dd>Scroll all the way down</dd>
                                      </dl>
                                      </div><!--/.column.last -->
                                      </div>

                                      </div>


                                      <!-- [if IE 8] >
                                      <script type= "text/javascript" charset= "utf-8" >
                                      $ (document.body) .addClass ("ie8")
                                      </script>
                                      <! [endif] -->

                                      <!-- [if IE 7] >
                                      <script type= "text/javascript" charset= "utf-8" >
                                      $ (document.body) .addClass ("ie7")
                                      </script>
                                      <! [endif] -->

                                      <script type= "text/javascript" >
                                      _kmq.push (['trackClick ', 'entice-signup-button ', 'Entice banner clicked ']);

                                                  </script>

                                                  </body>
                                                  </html>

