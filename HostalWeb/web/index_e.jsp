<%-- 
    Document   : index
    Created on : 16-05-2018, 23:36:34
    Author     : 420NiggaBytes
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true"%>
<!DOCTYPE html>
<html lang="es">
<head>
	<meta charset="UTF-8">
	<title>Hostal Doña Clarita</title>
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
     <link rel="stylesheet" href="css/estilos.css">	
     <link rel="stylesheet" href="css/font.css"> 
     <link rel="stylesheet" href="css/footer-distributed-with-address-and-phones.css">
     <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
	<header class="header">
		<div class="contenedor">
			<h1 class="logo">Hostal Clarita</h1>
			<span class="icon-menu" id="btn-menu"></span>
			<nav class="nav" id="nav">
				<ul class="menu">
					<li class="menu__item"><a class="menu__link select" href="">Inicio</a></li>
					<li class="menu__item"><a class="menu__link" href="">Servicios</a></li>
					<li class="menu__item"><a class="menu__link" href="">Galeria</a></li>
                                        <li class="menu__item"><a class="menu__link" href="indexEmpresa.jsp">Mi Perfil</a></li>
				</ul>
			</nav>
		</div>
	</header>
	<div class="banner">
		<img src="img/image.jpg" alt="" class="banner__img">		
	</div>
	<main class="main">
		<div class="contenedor">	
		<section class="info">
			<article class="info__columna">
                            <img src="img/f_img_1.png" alt="" class="info__img">
				<h2 class="info__titulo">Descansa como nunca.</h2>
				<p class="info__txt">Ofrecemos un grato ambiente de descanso para que olvides que estas de trabajo! </p>
			</article>
			<article class="info__columna">
				<img src="img/detalle.jpg" alt="" class="info__img">
				<h2 class="info__titulo">Come relajado </h2>
				<p class="info__txt">Los mejores desayunos a la puerta de tu habitacion,con los mejores cheff del pais!.</p>
			</article>
			<article class="info__columna">
                            <img src="img/reception.jpg" alt="" class="info__img">
				<h2 class="info__titulo">Pide el servicio a toda hora</h2>
				<p class="info__txt">Pide lo que quieras,a la hora que quieras!,entregamos los mejores servicios a toda hora.</p>
			</article>
		</section>	
		<section class="juguetes">
			<h2 class="section__titulo">Habitaciones</h2>
			<div class="juguetes__columna">
				<img src="img/img_1.jpg" alt="" class="juguetes__img">
				<div class="juguetes__descripcion">
					<h3 class="juguetes__titulo">Habitacion</h3>
					<p class="juguetes__txt">Amoblada con cama para 2 personas.</p>
				</div>
			</div>
			<div class="juguetes__columna">
				<img src="img/img_5.jpg" alt="" class="juguetes__img">
				<div class="juguetes__descripcion">
					<h3 class="juguetes__titulo">Habitacion</h3>
					<p class="juguetes__txt">Habitacion matrimonial.</p>
				</div>
			</div>
			<div class="juguetes__columna">
				<img src="img/img_3.jpg" alt="" class="juguetes__img">
				<div class="juguetes__descripcion">
					<h3 class="juguetes__titulo">Habitacion</h3>
					<p class="juguetes__txt">Hermosa habitacion con buena iluminacion</p>
				</div>
			</div>
			<div class="juguetes__columna">
				<img src="img/img_4.jpg" alt="" class="juguetes__img">
				<div class="juguetes__descripcion">
					<h3 class="juguetes__titulo">Habitacion</h3>
					<p class="juguetes__txt">Habitacion blanca como la nieve.</p>
				</div>
			</div>
		</section>				
		</div>	
	</main>
	<footer class="footer-distributed">

			<div class="footer-left">

				<h3>Hostal Doña<span>Clarita</span></h3>

				<p class="footer-links">
					<a href="#">Inicio</a>
					·
					<a href="#">Servicios</a>
					·
					<a href="#">Galeria</a>
					·
					<a href="#">Iniciar Sesión</a>					·
					
					<a href="#">Contacto</a>
				</p>

				<p class="footer-company-name">Doña Clarita &copy; 2018</p>
			</div>

			<div class="footer-center">

				<div>
					<i class="fa fa-map-marker"></i>
					<p><span>21 Revolution Street</span> Santiago, Chile</p>
				</div>

				<div>
					<i class="fa fa-phone"></i>
					<p>+56 22 24527342</p>
				</div>

				<div>
					<i class="fa fa-envelope"></i>
					<p><a href="mailto:hostalclarita@gmail.com">hostalclarita@gmail.com</a></p>
				</div>

			</div>

			<div class="footer-right">

				<p class="footer-company-about">
					<span>Sobre El Hostal</span>
					Hostal Doña Clarita es una empresa familiar dedicada al alojamiento y servicio de comedor,para trabajadores que recorren Chile.
				</p>

				<div class="footer-icons">
					<a href="#"><i class="fa fa-facebook"></i></a>
					<a href="#"><i class="fa fa-twitter"></i></a>
					<a href="#"><i class="fa fa-linkedin"></i></a>
					<a href="#"><i class="fa fa-github"></i></a>

				</div>

			</div>

		</footer>
	<script src="js/menu.js"></script>
</body>
</html>