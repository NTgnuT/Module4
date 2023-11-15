create database session2_bt1;
use session2_bt1;

create table phieu_xuat(
SoPX int primary key auto_increment,
NgayXuat date
);

create table vat_tu(
MaVTU int primary key auto_increment,
TenVTU varchar(255)
);

create table phieu_nhap(
SoPN int primary key auto_increment,
NgayNhap date
);

create table chi_tiet_phieu_xuat(
SoPN int,
foreign key (SoPN) references phieu_xuat (SoPX),
MaVTU int,
foreign key (MaVTU) references vat_tu (MaVTU),
DGXuat int,
SLXuat int
);

create table chi_tiet_phieu_nhap(
MaVTU int,
foreign key (MaVTU) references vat_tu (MaVTU),
SoPN int,
foreign key (SoPN) references phieu_nhap (SoPN),
DGNhap int,
SLNhap int
);

create table nha_cung_cap (
MaNCC int primary key auto_increment,
TenNCC varchar(255),
DiaChi varchar(255),
SDT varchar(10)
);

create table don_dat_hang(
MaNCC int, 
foreign key (MaNCC) references nha_cung_cap (MaNCC),
SoDH int primary key auto_increment,
NgayDH date
);

create table chi_tiet_don_dat_hang(
MaVTU int,
foreign key (MaVTU) references vat_tu (MaVTU),
SoDH int,
foreign key (SoDH) references don_dat_hang (SoDH),
SoLuongSP int
);



