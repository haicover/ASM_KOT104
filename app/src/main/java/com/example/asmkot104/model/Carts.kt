package com.example.asmkot104.model

data class Carts(
    val id: Int,
    val title: String,
    val price: Double,
    val pic: String,
    val quantity: Int
)

val cartItem = listOf(
    Carts(
        id = 0,
        title = "Minimal Stand 1",
        price = 25.00,
        pic = "https://s3-alpha-sig.figma.com/img/01b3/a6d6/88ed658a2d0159fe18074af4a860b24f?Expires=1717372800&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=jC7Akq5PplALKblmLXCNHZEt60MPSe5JhohgtIn1WVv4SWi6n~-JbpWQK4ohvmCE5fG41Qjuy7AvPSf3OK8bm3~hWKJeCuyAcdcmI35-QE-pKIohHvTVURQyeFSQjze6siLsBO~SxI3kjMu7LhFwFmMMQceoP1dcgFZMPOQjiMS9c6Wb2m0zz7mETVm1dLqmZR6QEdITqqJqW0vGvOFGpAeQ9O2t8Y7JYwWGSCZk4dTVNBGE6amcVsoeyps~NuKp4jvH1QfhJdmczZK2iesThOsn2ruH34tS6xKRsCYhKqGE2Dlhjdx0giA8OWMqnF79lKX6TOhab3I4OOXuVxEKEw__",
        quantity = 1,

        ),
    Carts(
        id = 1,
        title = "Black Simple Lamp",
        price = 12.00,
        pic = "https://s3-alpha-sig.figma.com/img/2443/fe11/03a0919f36f923a162b57615bd507c3e?Expires=1717372800&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=bi~cSfbMxTuoS0Br1ACqbx~723O2dNbiV6WjeFNIPwkouzJaJOxxiDRO2p8LQnJtaGcOCy2W4HNeQqZ1B5e9~u66Kn0BlpWsDzeHwwYfgZ4-M4KZP9nv3GtHEzh6JkY8xz5nhKL6tEgtcp2wuBtby8hAdFe981nf5AqD6w4eAjCpUshEanZvE8AQBgW7gn3zoD7N1Y8QlDwSFPrH9aKjzN5-6Qk2IyrhrE98U74kCgt4oT1cW-u94WsAzSKmcUVLaLTYa2eosUGSanxA8U1LbSiw1h8oJ-1GdgEv6p1CBcC1UNInD0gn3PFO1P~o8mUkimAOEs0~OiS9R1KLjgqDaA__",
        quantity = 1,

        ),
    Carts(
        id = 2,
        title = "Minimal Stand 2",
        price = 29.00,
        pic = "https://s3-alpha-sig.figma.com/img/01b3/a6d6/88ed658a2d0159fe18074af4a860b24f?Expires=1717372800&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=jC7Akq5PplALKblmLXCNHZEt60MPSe5JhohgtIn1WVv4SWi6n~-JbpWQK4ohvmCE5fG41Qjuy7AvPSf3OK8bm3~hWKJeCuyAcdcmI35-QE-pKIohHvTVURQyeFSQjze6siLsBO~SxI3kjMu7LhFwFmMMQceoP1dcgFZMPOQjiMS9c6Wb2m0zz7mETVm1dLqmZR6QEdITqqJqW0vGvOFGpAeQ9O2t8Y7JYwWGSCZk4dTVNBGE6amcVsoeyps~NuKp4jvH1QfhJdmczZK2iesThOsn2ruH34tS6xKRsCYhKqGE2Dlhjdx0giA8OWMqnF79lKX6TOhab3I4OOXuVxEKEw__",
        quantity = 1,
    ),
    Carts(
        id = 3,
        title = "Coffee Chair",
        price = 25.00,
        pic = "https://s3-alpha-sig.figma.com/img/91be/dce9/4217675b32a96dfef341a89d632c6452?Expires=1717372800&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=KMflxAmJMeAE8Egxvkacse5KVOdb8iq~~qhsNMKAx2b9ZPalZ7kHKqy~kJtBMTOQkypQqt8iVO3huHG7fwVHPruTKLv64oSVS-DYhTWUCzxpsefNVp~vYmq7EkLP99Dwt1VEZB5RhkvDCOGdGZObpYIACP5Mf5GucwZ-PAQ1WMKZwGJjFS-ufER3YpcE8j~hxWNh5gv4kjq9bQ81eamKnFDHYQyeQQNCzWNJDVeptX~i52KCI3MfMfpsb1vE6-L9rJkTP~57JqMSWCjxL9STlRQNaK0Hh9R3FCDcYX0dYVqTY0dv~WE3Bw1isqgcquep5YP~v58TAz7l0A6bEvToSg__",
        quantity = 1,
    ),
    Carts(
        id = 4,
        title = "Coffee Table",
        price = 22.00,
        pic = "https://s3-alpha-sig.figma.com/img/d2cc/b173/ffcf81766d608d6e6d7a70ae8ebfe5bb?Expires=1717372800&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=qA-wWyLSJjlookdyGWYmIpqWWywz2gJxwDFUybcfJnUEvrUCJtTxguYk~xEGYXsP1D6rSPX8liRVjKGKqRBItW27NqIfYXYyR7PxVYr4RUP2omlqlL-Lnm6tl6~0qEPwqn3vXPfkjH~QyDJjRF~mliXKgs0pir~-2idi55HFYXJC4qKw2jNZPEa8GUtYnt3xb~plRdjYiP7gqiKEoOoMNC8QWYD56IqzoYhURT2vTfnevZ7ei-vtCylE5TD5YdEOp1xSfGWPpnCcLEerHlKNUZO0wFABP3J8OnxBpGPOBz0uk~ay8Qf4q96gyrjx8o1qb~Dwq2WUlfedPmM0VMaWNA__",
        quantity = 1,
    ),
    Carts(
        id = 5,
        title = "Minimal Desk",
        price = 1.00,
        pic = "https://s3-alpha-sig.figma.com/img/d628/863f/83328d299b2df6ee0daa119655bdd3f5?Expires=1717372800&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=q3tKwpobrK2HqSYUvfcbl36-pE4KYher~KZgM4cwKyr9HS7LXsF0MSrG2fuUHY0us8ScEzArMxa4R7HJMdiyWbM3I18y448iTRfuqs2i5g1apLXglOtJqDHfRGk~4JOCYGRAsP2PWBbPyIiSxins50rGAV9AcgY3h0tMkTF-v~bszqkOHV9cpIkDfZg6scwO7PfRnv4ppocCRMIXc2tnXbdexBUSjBdPsOENn9IBBWHNJokkx3tJ99aNM93mTAHnGcqVQWCuFCBapltoQBi6quC5efp5y-BttEsWhK9dqRUcRMcWp~TOUM81Kc7DaLRNEom4LiK4Y~ODe4XCr6XkYg__",
        quantity = 1,
    ),
    Carts(
        id = 6,
        title = "Coffee Table",
        price = 10.00,
        pic = "https://s3-alpha-sig.figma.com/img/91be/dce9/4217675b32a96dfef341a89d632c6452?Expires=1717372800&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=KMflxAmJMeAE8Egxvkacse5KVOdb8iq~~qhsNMKAx2b9ZPalZ7kHKqy~kJtBMTOQkypQqt8iVO3huHG7fwVHPruTKLv64oSVS-DYhTWUCzxpsefNVp~vYmq7EkLP99Dwt1VEZB5RhkvDCOGdGZObpYIACP5Mf5GucwZ-PAQ1WMKZwGJjFS-ufER3YpcE8j~hxWNh5gv4kjq9bQ81eamKnFDHYQyeQQNCzWNJDVeptX~i52KCI3MfMfpsb1vE6-L9rJkTP~57JqMSWCjxL9STlRQNaK0Hh9R3FCDcYX0dYVqTY0dv~WE3Bw1isqgcquep5YP~v58TAz7l0A6bEvToSg__",
        quantity = 1,
    ),
    Carts(
        id = 7,
        title = "Minimal Stand",
        price = 23.00,
        pic = "https://s3-alpha-sig.figma.com/img/01b3/a6d6/88ed658a2d0159fe18074af4a860b24f?Expires=1717372800&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=jC7Akq5PplALKblmLXCNHZEt60MPSe5JhohgtIn1WVv4SWi6n~-JbpWQK4ohvmCE5fG41Qjuy7AvPSf3OK8bm3~hWKJeCuyAcdcmI35-QE-pKIohHvTVURQyeFSQjze6siLsBO~SxI3kjMu7LhFwFmMMQceoP1dcgFZMPOQjiMS9c6Wb2m0zz7mETVm1dLqmZR6QEdITqqJqW0vGvOFGpAeQ9O2t8Y7JYwWGSCZk4dTVNBGE6amcVsoeyps~NuKp4jvH1QfhJdmczZK2iesThOsn2ruH34tS6xKRsCYhKqGE2Dlhjdx0giA8OWMqnF79lKX6TOhab3I4OOXuVxEKEw__",
        quantity = 1,
    ),
)
