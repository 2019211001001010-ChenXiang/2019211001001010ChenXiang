<%--
<%@include file="header.jsp"%>
	<section id="slider"><!--slider-->
		<div class="container">
			<div class="row">
				<div class="col-sm-12">
					<div id="slider-carousel" class="carousel slide" data-ride="carousel">
						<ol class="carousel-indicators">
							<li data-target="#slider-carousel" data-slide-to="0" class="active"></li>
							<li data-target="#slider-carousel" data-slide-to="1"></li>
							<li data-target="#slider-carousel" data-slide-to="2"></li>
						</ol>
						
						<div class="carousel-inner">
							<div class="item active">
								<div class="col-sm-6">
									<h1><span>E</span>-SHOPPER</h1>
									<h2>My E-Commerce Website</h2>
									<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. </p>
									<button type="button" class="btn btn-default get">Get it now</button>
								</div>
								<div class="col-sm-6">
									<img src="<%=basePath%>images/home/girl1.jpg" class="girl img-responsive" alt="" />
									<img src="<%=basePath%>images/home/pricing.png"  class="pricing" alt="" />
								</div>
							</div>
							<div class="item">
								<div class="col-sm-6">
									<h1><span>E</span>-SHOPPER</h1>
									<h2>100% Responsive Design</h2>
									<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. </p>
									<button type="button" class="btn btn-default get">Get it now</button>
								</div>
								<div class="col-sm-6">
									<img src="<%=basePath%>images/home/girl2.jpg" class="girl img-responsive" alt="" />
									<img src="<%=basePath%>images/home/pricing.png"  class="pricing" alt="" />
								</div>
							</div>
							
							<div class="item">
								<div class="col-sm-6">
									<h1><span>E</span>-SHOPPER</h1>
									<h2>My Ecommerce Website</h2>
									<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. </p>
									<button type="button" class="btn btn-default get">Get it now</button>
								</div>
								<div class="col-sm-6">
									<img src="<%=basePath%>images/home/girl3.jpg" class="girl img-responsive" alt="" />
									<img src="<%=basePath%>images/home/pricing.png" class="pricing" alt="" />
								</div>
							</div>
							
						</div>
						
						<a href="#slider-carousel" class="left control-carousel hidden-xs" data-slide="prev">
							<i class="fa fa-angle-left"></i>
						</a>
						<a href="#slider-carousel" class="right control-carousel hidden-xs" data-slide="next">
							<i class="fa fa-angle-right"></i>
						</a>
					</div>
					
				</div>
			</div>
		</div>
	</section><!--/slider-->
<%@include file="footer.jsp"%>--%>
<html>
<body>
	<% //set in page, request, session, application
    pageContext . setAttribute ("attName", "att in page");
    request. setAttribute ("attName", "att in request ") ;
    session. setAttribute ("attName", "att in session") ;
    application. setAttribute ("attName", "att in application") ;%>
    <%out.println("<br/>"+pageContext.getAttribute ("attName"));
	  out.println("<br/>"+request.getAttribute ("attName"));
      out.println("<br/>"+session.getAttribute ("attName"));
      out.println("<br/>"+application.getAttribute ("attName"));
      %>
	<br/><hr/><h4>Use pageContext to get attribute from page, request, session and application</h4>
	<% out.println("<br/>"+pageContext.getAttribute("attName",PageContext. PAGE_SCOPE));
       out.println("<br/>"+pageContext.getAttribute("attName",PageContext.REQUEST_SCOPE));
       out.println("<br/>"+pageContext.getAttribute("attName",PageContext.SESSION_SCOPE));
       out.println("<br/>"+pageContext.getAttribute("attName",PageContext.APPLICATION_SCOPE));
%>
    <br/><hr/><h4>Use pageContext to Find attribute from page , request, session and application</h4>
    <%=pageContext.findAttribute("attName") %>
	<!-- search in page , request, session and application ,= find first one-->
    </body>
    </html>

