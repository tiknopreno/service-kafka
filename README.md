# JIKA BELUM ADA CONTAINER KAFKA PADA DOCKER
docker compose up -d

# BPMN
Penjelasan alur prose :
* Start
* User : Trigger dari rest api /api/checkout
* Procedur even ke kafka topic checkout.initiated
* Konsumsi event oleh kafka consumer
* Validasi keranjang dan stok
* Manipulasi data (timestamp dll)
* Prouksi event ke checkout.proccesed
* Pembuatan order dan pemrosesan pembayaran
* Decision : Suskes atau gatal
* Produksi event ke checkout.complete atau checkout.failed
* Notifikasi keuser
* End
