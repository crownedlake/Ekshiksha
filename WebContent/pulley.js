function pulley_creator(radius){
	
	var group = new THREE.Object3D();
	
	var geometry = new THREE.CircleGeometry(radius,32);
	var material = new THREE.MeshBasicMaterial( {color:0xff0000} );
	var pulley2 = new THREE.Mesh( geometry, material );
	pulley2.position.set(0,0,0);
	pulley2.rotation.x=Math.PI/2;
	group.add(pulley2);
	
	var pbar1 = new Array();
	for(var i=0;i<8;i++)
	{
		geometry = new THREE.BoxGeometry(0.02,radius*2,0);
		material = new THREE.MeshBasicMaterial({ color: 0xa67643});
		pbar1[i] = new THREE.Mesh(geometry,material);
		pbar1[i].position.set(0,0,0);
		group.add(pbar1[i]);
		pbar1[i].rotation.z=i*Math.PI/8;
	}
	scene.add(group);
	
	return group;
}