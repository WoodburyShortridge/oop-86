// Global variables
var scene, renderer, camera, controls, button, selected;

// boiler mostly taken from class example
window.onload = function () {
	// Most browsers now support WebGLRenderer
	renderer = new THREE.WebGLRenderer( { antialias: true } );
	renderer.setClearColor( new THREE.Color ("black"))
	renderer.setSize( window.innerWidth, window.innerHeight );
	document.getElementById('main').appendChild(renderer.domElement);

	// Create the scene
	scene = new THREE.Scene();

	// Put a camera into the scene
	camera = new THREE.PerspectiveCamera( 60, window.innerWidth / window.innerHeight, 1, 1000 );
	camera.position.set(0,0, -5);
	scene.add(camera);

	// Create a camera contol
	controls = new THREE.OrbitControls( camera, renderer.domElement );
	controls.addEventListener( 'change', render );

  // create destory BUTTON
  button = new DestoryControl();
  document.getElementById('main').appendChild(button.btn);

  // create selected store
  selected = []

	// Add our stuff to the scene, kept in a separate function
	makeSceneGraph()

	render()
	animate()
}

// Render the scene
function render() {
	renderer.render( scene, camera );
}

// In case window is resized
window.onresize = function () {
	renderer.setSize( window.innerWidth, window.innerHeight );
	camera.aspect = window.innerWidth / window.innerHeight;
	camera.updateProjectionMatrix();
	render();
}

function makeSceneGraph () {
	myScene = new Scene()
	scene.add (myScene)
	// mouse down listner
	document.addEventListener ("mousedown", onUserSelect, false)
}

animate = function () {
	requestAnimationFrame( animate );
	myScene.tick()
	controls.update()
}

function randomNumber (a,b) {
  return Math.floor(Math.random() * b) + a;
}

class Scene extends THREE.Object3D {
  constructor () {
    	super()

      // set up lights
      this.mainLight = new THREE.DirectionalLight ("white", 1)
    	this.mainLight.position.set (1, 0.5, 1)
    	scene.add (this.mainLight)

      this.ambientLight = new THREE.AmbientLight (0x404040)
    	scene.add (this.ambientLight);

      this.orbit = new Orbit ()
      this.orbit.position.set (-50,-50,50)
      this.add (this.orbit)
  }

  // pass tick to objects
  tick () {
  	this.orbit.tick()
    render();
  }
}

class Orbit extends THREE.Object3D {
  constructor () {
    super()
    // List of Cubes
    this.cubes = []
    for (var i = 0; i < 100; i++) {
      this.cubes[i] = new Cube ()
      this.cubes[i].position.set (randomNumber(0,100), randomNumber(0,100), randomNumber(-100,100))
      this.add ( this.cubes[i])
    }

    // List of Cylinder
    this.cylinders = []
    for (var i = 0; i < 100; i++) {
      this.cylinders[i] = new Cylinder ()
      this.cylinders[i].position.set (randomNumber(0,100), randomNumber(0,100), randomNumber(-100,100))
      this.add ( this.cylinders[i])
    }

    // List of Torus
    this.toruses = []
    for (var i = 0; i < 100; i++) {
      this.toruses[i] = new Torus ()
      this.toruses[i].position.set (randomNumber(0,100), randomNumber(0,100), randomNumber(-100,100))
      this.add ( this.toruses[i])
    }
  }
  // pass tick to objects
  tick () {
  	for (var c of this.cubes) {
  		c.tick()
  	}
    for (var cy of this.cylinders) {
  		cy.tick()
  	}
    for (var t of this.toruses) {
  		t.tick()
  	}
    // this.rotation.x += 0.01;
   render();
  }
}

class Cube extends THREE.Object3D {
  constructor () {
    super()
    var geometry, material, cube;
    geometry = new THREE.BoxGeometry( 1, 1, 1 );
    material = new THREE.MeshNormalMaterial();
    cube = new THREE.Mesh( geometry, material );
    this.add(cube)
  }
  tick() {
    this.rotation.x += 0.01;
    this.rotation.y += 0.02;
  }
}

class Cylinder extends THREE.Object3D {
  constructor () {
    super()
    var geometry, material, cylinder;
    geometry = new THREE.CylinderGeometry( 1, 1, 1, 100 );
    material = new THREE.MeshNormalMaterial();
    cylinder = new THREE.Mesh( geometry, material );
    this.add(cylinder)
  }
  tick() {
    this.rotation.x += 0.01;
    this.rotation.y += 0.02;
  }
}

class Torus extends THREE.Object3D {
  constructor () {
    super()
    var geometry, material, torus, dodec;
    geometry = new THREE.TorusGeometry( 2, 1, 10, 100 );
    material = new THREE.MeshNormalMaterial();
    torus = new THREE.Mesh( geometry, material );
    this.add( torus );

    this.dodec = new Dodec ()
    // dodec.position.set (-10 + i*2, -3 + i, -1 + i)
    this.add ( this.dodec)
  }
  tick() {
    this.rotation.x += 0.001;
    this.rotation.y += 0.002;
    this.dodec.tick();
  }
}

class Dodec extends THREE.Object3D {
  constructor () {
    super()
    var geometry, material, dodec;
    geometry = new THREE.DodecahedronGeometry( 1, 0 );
    material = new THREE.MeshNormalMaterial();
    dodec = new THREE.Mesh( geometry, material );
    this.add( dodec );
  }
  tick() {
    this.rotation.x += 0.01;
    this.rotation.y += 0.02;
  }
}

class DestoryControl {
  constructor () {
    this.btn = document.createElement("BUTTON");
    this.btn.innerHTML = "Destroy !"
    this.btn.addEventListener ("mousedown", this.destroy, false)
  }
  destroy() {
    for (var s of selected) {
      s.object.material = new THREE.MeshPhongMaterial ({ color: 'black' })
      scene.remove(s)
      render()
    }
  }
}

// mouse down
function onUserSelect (event) {
	var mouse = {
		x: ( event.clientX / window.innerWidth ) * 2 - 1,
		y: - ( event.clientY / window.innerHeight ) * 2 + 1 }

	// Set up for picking
	var raycaster = new THREE.Raycaster ()
	raycaster.setFromCamera (mouse, camera)

	// Returns array of all objects in scene with which the ray intersects
	var intersects = raycaster.intersectObjects (scene.children, true);

	// If there were any intersections, take the first (ie nearest)
	if (intersects.length > 0) {
		intersects[0].object.material = new THREE.MeshPhongMaterial ({ color: 0xFF69B4 })
    selected.push(intersects[0])
		render()
	}
}
