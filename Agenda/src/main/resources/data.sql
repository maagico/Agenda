INSERT INTO `roles` (`id`, `rol`, `nombre`) VALUES
(3, 'ROLE_USUARIO', 'Usuario'),
(4, 'ROLE_ADMIN', 'Admin');

INSERT INTO `usuarios` (`id`, `usuario`, `password`, `role_id`) VALUES
(2, 'admin', '$2a$10$C6IMLHb5Rt1VWBBTXhyxw.EmTBXcg//9yTxU1LhtvwvmBx4IT43x2', 4),
(5, 'usuario', '$2a$10$6rC.Hty68SvsTw33Ah2TGOarAfsTX2GyQxSMw4dpNAE1J6WYN7fDW', 3),
(6, 'usuario1', '$2a$10$Yqsp9f4bDWqneGJU8vu2NeCs0GwH0xxhdqZTDbbtEfKy9xMyas4/W', 3);

INSERT INTO `contactos` (`id`, `nombre`, `apellidos`, `usuario_id`) VALUES
(6, 'Peter', 'Parker', 5),
(7, 'Bruce', 'Wayne', 5),
(8, 'Bruce', 'Banner', 6);

INSERT INTO `correos` (`id`, `correo`, `contacto_id`) VALUES
(19, 'peter@parker.com', 6),
(20, 'bruce@indutriaswayne.com', 7),
(21, 'hulk@marvel.com', 8);

INSERT INTO `telefonos` (`id`, `numero`, `contacto_id`) VALUES
(22, '987654321', 6),
(23, '123456789', 6),
(24, '875482198', 7),
(25, '976576432', 8);

ALTER TABLE `contactos`
  ADD CONSTRAINT `usuario_contactos` FOREIGN KEY (`usuario_id`) REFERENCES `usuarios` (`id`);

ALTER TABLE `correos`
  ADD CONSTRAINT `correos_contacto` FOREIGN KEY (`contacto_id`) REFERENCES `contactos` (`id`);

ALTER TABLE `telefonos`
  ADD CONSTRAINT `contacto_telefonos` FOREIGN KEY (`contacto_id`) REFERENCES `contactos` (`id`);

ALTER TABLE `usuarios`
  ADD CONSTRAINT `usuario_roles` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`);
