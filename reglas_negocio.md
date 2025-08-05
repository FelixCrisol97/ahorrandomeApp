# REGLAS_NEGOCIO.md

## 📜 Reglas de Negocio del Sistema de Finanzas Personales

Este documento establece las reglas de comportamiento que debe respetar la aplicación durante la ejecución de sus funcionalidades. Estas reglas servirán como base para validaciones, pruebas automáticas y diseño de UX.

---

### 🧭 Movimiento de gastos e ingresos

- Los **gastos e ingresos deben tener fecha no futura**.
- El **monto debe ser positivo** y no exceder un límite definido (configurable por perfil).
- Un movimiento puede ser **editado sólo dentro de las 48 horas posteriores** a su creación.
- Una **nota es opcional**, pero si existe debe tener máximo 255 caracteres.
- Una **foto es opcional**; si se adjunta, debe tener formato válido (`jpg`, `png`, `webp`) y tamaño máximo de 5 MB.
- Cada movimiento debe pertenecer a **una cuenta, una categoría y un usuario**.

---

### 🗂️ Categorías personalizadas

- Cada usuario puede crear hasta **50 categorías por tipo** (`GASTO`, `INGRESO`).
- Los nombres de categoría deben ser **únicos dentro del mismo tipo y usuario**.
- No se puede eliminar una categoría si tiene movimientos asociados, salvo que se reemplacen o se marquen como “sin categoría”.
- Las categorías pueden editarse, pero su tipo (`GASTO`/`INGRESO`) no puede cambiarse una vez usadas.

---

### 💼 Tipos de cuenta

- Los usuarios pueden crear hasta **20 cuentas personales**.
- El nombre debe ser **único dentro del usuario** y tener máximo 30 caracteres.
- No se puede eliminar una cuenta si tiene movimientos activos; debe ser primero vaciada o desactivada.

---

### 🔐 Usuario y autenticación

- El correo electrónico debe ser único en el sistema.
- La contraseña se guarda con **hash seguro**; nunca en texto plano.
- La foto de perfil debe cumplir los mismos requisitos que las fotos de movimiento (extensión, tamaño).
- Un usuario puede tener un solo perfil activo; roles se definen en futuras versiones (ej. familia, socios).

---

### 📊 Reportes

- Se pueden generar reportes por rangos válidos de fecha (`from` ≤ `to`).
- El tipo de reporte (`daily`, `monthly`, `custom`) define el nivel de agrupamiento.
- Sólo el usuario dueño puede generar reportes con base en sus datos.

---

### 🎯 Metas financieras

- Cada meta debe tener una **cantidad total**, una **fecha límite** y un **nombre único por usuario**.
- Los movimientos asociados a metas no pueden exceder el monto total definido.
- Las metas vencidas pasan a estado “archivada” y ya no reciben movimientos nuevos.

---

### 🔐 Modo privado y acceso seguro

- Los montos en modo privado se ocultan por defecto.
- Activar visualización requiere validación por PIN o biometría (según dispositivo).
- Ciertas secciones como reportes o gráficos también respetan este modo discreto.

---

### 🧠 General

- Todos los registros deben estar vinculados a un usuario autenticado.
- El sistema debe validar duplicidad de movimientos por monto, fecha y categoría si ocurren en menos de 5 minutos.
- Las acciones de editar y eliminar deben registrarse en una **bitácora de actividad por usuario**.

---

Este archivo está sujeto a expansión conforme crezcan los módulos o se definan comportamientos específicos por rol, grupo o integración externa.

