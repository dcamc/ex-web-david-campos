#language: es
@testlinio
Característica: Login
  Yo, como usuario
  Quiero, tener una opción para iniciar sesión
  Para ver todos los items

  @test
  Escenario: Iniciar sesión
    Dado que me encuentro en la página de login de Linio
    Cuando inicio sesión con credenciales usuario: "yarago7876@zfobo.com" y contraseña: "prueba123"
    Y valido que estoy logeado correctamente con el usuario: "asdasd"
    Y añado producto al carrito
    Y valido que el producto ha sido añadido