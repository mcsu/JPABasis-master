JPABasis
========

Gradle + Eclipse + JPA with Eclipse Link and HSQLDB

HSQLDB Data base setup :
- download and uncompress hsqldb from hsqldb.org
- version hsqldb_1_8_1_3 is used
- start the data base server with this command line (into the lib directory of HSQLDB) : java -cp hsqldb.jar org.hsqldb.Server
- using a tool to inspect the data base:
  - use a command line (into the lib directory of HSQLDB) : java -cp hsqldb.jar org.hsqldb.util.DatabaseManagerSwing
  - in the connection window choose as the type: HSQL Database Engine Server

-ADB  answer
check all fields
<script type="text/javascript">
											function myF(){		
												var els = document.getElementsByTagName('input');
												
												for(var i = 0; i!=(els.length - 1);i++){
													var exp = /^chp.*/g;
													if(exp.test(els[i].getAttribute("name"))){
														if(!els[i].value || !els[i].value.length) {
															alert("Missing field:"+els[i].getAttribute("name"));
														}
													}
												}
										}
										<
                    /script>
