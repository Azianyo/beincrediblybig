<!DOCTYPE html>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="styleDiet.css" >
<script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<script type="text/JavaScript" src="js/index.js"></script>
<html>
<div class="row">
	<div class="col-md-2"></div>
	<div class="col-md-8">
		<head>
			<title>Wygenerowany jadlospis</title>
			<link rel="stylesheet" href="styleDiet.css" type="text/css">
			<div class="alert alert-success" role="alert"><img src="<%=request.getContextPath()%>/images/bialko_nagl.jpg" alt="nagl" class="img-thumbnail"><h1>Twoj jadlospis na tydzien! Nic tylko przybierac na masie!</h1></div>
		</head>
		<body>
		<ul class="nav nav-pills" role="tablist">
			<a href="#PON"><button type="button" class="btn btn-default navbar-btn">Poniedzialek</button></a>
			<a href="#WT"><button type="button" class="btn btn-default navbar-btn">Wtorek</button></a>
			<a href="#SR"><button type="button" class="btn btn-default navbar-btn">Sroda</button></a>
			<a href="#CZW"><button type="button" class="btn btn-default navbar-btn">Czwartek</button></a>
			<a href="#PT"><button type="button" class="btn btn-default navbar-btn">Piatek</button></a>
			<a href="#SO"><button type="button" class="btn btn-default navbar-btn">Sobota</button></a>
			<a href="#ND"><button type="button" class="btn btn-default navbar-btn">Niedziela</button></a>
		</ul>
		<a name="PON"></a>
		<div class="jumbotron">
			<div class="row">
				<div class="col-md-1"></div>
				<div class="col-md-10">
					<div class="media">
						<a class="media-left" href="#">
							<img src="<%=request.getContextPath()%>/images/pon.jpg" alt="pon">
						</a>
						<div class="media-body">
							<div class="panel panel-default">
								<div class="panel-heading">
									<H1 class="panel-title">Poniedzialek</H1>
								</div>
								<div class="panel-body">
									<H2>Sniadanie</H2><br>
									...przepis<br>
									<H2>Obiad</H2><br>
									...przepis<br>
									<H2>Przed treningiem</H2><br>
									...przepis<br>
									<H2>Po treningu</H2><br>
									...przepis<br>
  									<H2>Kolacja</H2><br>
									...przepis<br>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="col-md-1"></div>
			</div>
		</div>
		<a name="WT"></a>
		<div class="jumbotron">
			<div class="row">
				<div class="col-md-1"></div>
				<div class="col-md-10">
					<div class="media">
						<div class="media-left">
							<a class="media-left" href="#">
								<img src="<%=request.getContextPath()%>/images/wt.jpg" alt="wt">
							</a>
						</div>
						<div class="media-body">
							<div class="panel panel-default">
								<div class="panel-heading">
									<H1 class="panel-title">Wtorek</H1>
								</div>
								<div class="panel-body">
									<H2>Sniadanie</H2><br>
									...przepis<br>
									<H2>Obiad</H2><br>
									...przepis<br>
									<H2>Przed treningiem</H2><br>
									...przepis<br>
									<H2>Po treningu</H2><br>
									...przepis<br>
									<H2>Kolacja</H2><br>
									...przepis<br>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="col-md-1"></div>
			</div>
		</div>
		<a name="SR"></a>
		<div class="jumbotron">
			<div class="row">
				<div class="col-md-1"></div>
				<div class="col-md-10">
					<div class="media">
						<div class="media-left">
							<a class="media-left" href="#">
								<img src="<%=request.getContextPath()%>/images/sr.jpg" alt="sr">
							</a>
						</div>
						<div class="media-body">
							<div class="panel panel-default">
								<div class="panel-heading">
									<H1 class="panel-title">Sroda</H1>
								</div>
								<div class="panel-body">
									<H2>Sniadanie</H2><br>
									...przepis<br>
									<H2>Obiad</H2><br>
									...przepis<br>
									<H2>Przed treningiem</H2><br>
									...przepis<br>
									<H2>Po treningu</H2><br>
									...przepis<br>
									<H2>Kolacja</H2><br>
									...przepis<br>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="col-md-1"></div>
			</div>
		</div>
		<a name="CZW"></a>
		<div class="jumbotron">
			<div class="row">
				<div class="col-md-1"></div>
				<div class="col-md-10">
					<div class="media">
						<div class="media-left">
							<a class="media-left" href="#">
								<img src="<%=request.getContextPath()%>/images/czw.jpg" alt="czw">
							</a>
						</div>
						<div class="media-body">
							<div class="panel panel-default">
								<div class="panel-heading">
									<H1 class="panel-title">Czwartek</H1>
								</div>
								<div class="panel-body">
									<H2>Sniadanie</H2><br>
									...przepis<br>
									<H2>Obiad</H2><br>
									...przepis<br>
									<H2>Przed treningiem</H2><br>
									...przepis<br>
									<H2>Po treningu</H2><br>
									...przepis<br>
									<H2>Kolacja</H2><br>
									...przepis<br>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="col-md-1"></div>
			</div>
		</div>
		<a name="PT"></a>
		<div class="jumbotron">
			<div class="row">
				<div class="col-md-1"></div>
				<div class="col-md-10">
					<div class="media">
						<div class="media-left">
							<a class="media-left" href="#">
								<img src="<%=request.getContextPath()%>/images/pt.jpg" alt="pt">
							</a>
						</div>
						<div class="media-body">
							<div class="panel panel-default">
								<div class="panel-heading">
									<H1 class="panel-title">Piatek</H1>
								</div>
								<div class="panel-body">
									<H2>Sniadanie</H2><br>
									...przepis<br>
									<H2>Obiad</H2><br>
									...przepis<br>
									<H2>Przed treningiem</H2><br>
									...przepis<br>
									<H2>Po treningu</H2><br>
									...przepis<br>
									<H2>Kolacja</H2><br>
									...przepis<br>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="col-md-1"></div>
			</div>
		</div>
		<a name="SO"></a>
		<div class="jumbotron">
			<div class="row">
				<div class="col-md-1"></div>
				<div class="col-md-10">
					<div class="media">
						<div class="media-left">
							<a class="media-left" href="#">
								<img src="<%=request.getContextPath()%>/images/so.jpg" alt="so">
							</a>
						</div>
						<div class="media-body">
							<div class="panel panel-default">
								<div class="panel-heading">
									<H1 class="panel-title">Sobota</H1>
								</div>
								<div class="panel-body">
									<H2>Sniadanie</H2><br>
									...przepis<br>
									<H2>Obiad</H2><br>
									...przepis<br>
									<H2>Przed treningiem</H2><br>
									...przepis<br>
									<H2>Po treningu</H2><br>
									...przepis<br>
									<H2>Kolacja</H2><br>
									...przepis<br>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="col-md-1"></div>
			</div>
		</div>
		<a name="ND"></a>
		<div class="jumbotron">
			<div class="row">
				<div class="col-md-1"></div>
				<div class="col-md-10">
					<div class="media">
						<div class="media-left">
							<a class="media-left" href="#">
								<img src="<%=request.getContextPath()%>/images/nd.jpg" alt="nd">
							</a>
						</div>
						<div class="media-body">
							<div class="panel panel-default">
								<div class="panel-heading">
									<H1 class="panel-title">Niedziela</H1>
								</div>
								<div class="panel-body">
									<H2>Sniadanie</H2><br>
									...przepis<br>
									<H2>Obiad</H2><br>
									...przepis<br>
									<H2>Przed treningiem</H2><br>
									...przepis<br>
									<H2>Po treningu</H2><br>
									...przepis<br>
									<H2>Kolacja</H2><br>
									...przepis<br>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="col-md-1"></div>
			</div>
		</div>
		<img src="<%=request.getContextPath()%>/images/bialko_nagl.jpg" alt="ale foka" class="img-rounded"><br><br>
		<button type="button" class="btn btn-default btn-lg">Drukuj</button><br><br>
		<nav>
			<ul class="pager">
				<li class="previous disabled"><a href="#"><span aria-hidden="true">&larr;</span> Wczorajsza wyżerka (w sumie te przyciski sa bez sensu...)</a></li>
				<li class="next"><a href="#"> Jutrzejsza wyżerka<span aria-hidden="true">&rarr;</span></a></li>
				// Tu by trzeba zrobic powrot do strony glownej
			</ul>
		</nav>
		</body>
	</div>
	<div class="col-md-2"></div>
</div>
</html>
