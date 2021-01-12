/*     */ package danger.orespawn;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.creativetab.CreativeTabs;
/*     */ import net.minecraft.enchantment.Enchantment;
/*     */ import net.minecraft.enchantment.EnchantmentHelper;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemArmor;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ItemOreSpawnArmor
/*     */   extends ItemArmor
/*     */ {
/*  32 */   private int armor_material = 0;
/*  33 */   private int armor_type = 0;
/*  34 */   private int original_d = 0;
/*     */ 
/*     */   
/*     */   public ItemOreSpawnArmor(int par1, ItemArmor.ArmorMaterial par2EnumArmorMaterial, int par3, int par4) {
/*  38 */     super(par2EnumArmorMaterial, par3, par4);
/*  39 */     setCreativeTab(CreativeTabs.tabCombat);
/*  40 */     this.armor_material = 0;
/*  41 */     if (par2EnumArmorMaterial == OreSpawnMain.armorLAVAEEL) {
/*  42 */       this.armor_material = 1;
/*     */     }
/*  44 */     if (par2EnumArmorMaterial == OreSpawnMain.armorMOTHSCALE) {
/*  45 */       this.armor_material = 2;
/*     */     }
/*  47 */     if (par2EnumArmorMaterial == OreSpawnMain.armorEMERALD) {
/*  48 */       this.armor_material = 3;
/*     */     }
/*  50 */     if (par2EnumArmorMaterial == OreSpawnMain.armorEXPERIENCE) {
/*  51 */       this.armor_material = 4;
/*     */     }
/*  53 */     if (par2EnumArmorMaterial == OreSpawnMain.armorRUBY) {
/*  54 */       this.armor_material = 5;
/*     */     }
/*  56 */     if (par2EnumArmorMaterial == OreSpawnMain.armorAMETHYST) {
/*  57 */       this.armor_material = 6;
/*     */     }
/*  59 */     if (par2EnumArmorMaterial == OreSpawnMain.armorPINK) {
/*  60 */       this.armor_material = 7;
/*     */     }
/*  62 */     if (par2EnumArmorMaterial == OreSpawnMain.armorTIGERSEYE) {
/*  63 */       this.armor_material = 8;
/*     */     }
/*  65 */     if (par2EnumArmorMaterial == OreSpawnMain.armorPEACOCK) {
/*  66 */       this.armor_material = 9;
/*     */     }
/*  68 */     if (par2EnumArmorMaterial == OreSpawnMain.armorMOBZILLA) {
/*  69 */       this.armor_material = 10;
/*     */     }
/*  71 */     if (par2EnumArmorMaterial == OreSpawnMain.armorROYAL) {
/*  72 */       this.armor_material = 11;
/*     */     }
/*  74 */     if (par2EnumArmorMaterial == OreSpawnMain.armorLAPIS) {
/*  75 */       this.armor_material = 12;
/*     */     }
/*  77 */     if (par2EnumArmorMaterial == OreSpawnMain.armorQUEEN) {
/*  78 */       this.armor_material = 13;
/*     */     }
/*  80 */     this.armor_type = par4;
/*     */     
/*  82 */     this.original_d = this.damageReduceAmount;
/*     */   }
/*     */ 
/*     */   
/*     */   public int get_armor_material() {
/*  87 */     return this.armor_material;
/*     */   }
/*     */ 
/*     */   
/*     */   public int get_armor_type() {
/*  92 */     return this.armor_type;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onCreated(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
/* 102 */     ArmorStats a = null;
/*     */     
/* 104 */     if (this.armor_material == 0) a = OreSpawnMain.Ultimate_armorstats; 
/* 105 */     if (this.armor_material == 1) a = OreSpawnMain.LavaEel_armorstats; 
/* 106 */     if (this.armor_material == 2) a = OreSpawnMain.MothScale_armorstats; 
/* 107 */     if (this.armor_material == 3) a = OreSpawnMain.Emerald_armorstats; 
/* 108 */     if (this.armor_material == 4) a = OreSpawnMain.Experience_armorstats; 
/* 109 */     if (this.armor_material == 5) a = OreSpawnMain.Ruby_armorstats; 
/* 110 */     if (this.armor_material == 6) a = OreSpawnMain.Amethyst_armorstats; 
/* 111 */     if (this.armor_material == 7) a = OreSpawnMain.Pink_armorstats; 
/* 112 */     if (this.armor_material == 8) a = OreSpawnMain.TigersEye_armorstats; 
/* 113 */     if (this.armor_material == 9) a = OreSpawnMain.Peacock_armorstats; 
/* 114 */     if (this.armor_material == 10) a = OreSpawnMain.Mobzilla_armorstats; 
/* 115 */     if (this.armor_material == 11) a = OreSpawnMain.Royal_armorstats; 
/* 116 */     if (this.armor_material == 12) a = OreSpawnMain.Lapis_armorstats; 
/* 117 */     if (this.armor_material == 13) a = OreSpawnMain.Queen_armorstats;
/*     */ 
/*     */     
/* 120 */     if (a != null) {
/* 121 */       if (a.e_protection != 0) par1ItemStack.addEnchantment(Enchantment.protection, a.e_protection); 
/* 122 */       if (a.e_fireprotection != 0) par1ItemStack.addEnchantment(Enchantment.fireProtection, a.e_fireprotection); 
/* 123 */       if (a.e_blastprotection != 0) par1ItemStack.addEnchantment(Enchantment.blastProtection, a.e_blastprotection); 
/* 124 */       if (a.e_projectileprotection != 0) par1ItemStack.addEnchantment(Enchantment.projectileProtection, a.e_projectileprotection); 
/* 125 */       if (a.e_unbreaking != 0) par1ItemStack.addEnchantment(Enchantment.unbreaking, a.e_unbreaking); 
/* 126 */       if (this.armor_type == 3 && 
/* 127 */         a.e_featherfalling != 0) par1ItemStack.addEnchantment(Enchantment.featherFalling, a.e_featherfalling);
/*     */       
/* 129 */       if (this.armor_type == 0) {
/* 130 */         if (a.e_respiration != 0) par1ItemStack.addEnchantment(Enchantment.respiration, a.e_respiration); 
/* 131 */         if (a.e_aquaaffinity != 0) par1ItemStack.addEnchantment(Enchantment.aquaAffinity, a.e_aquaaffinity);
/*     */       
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onUpdate(ItemStack stack, World par2World, Entity par3Entity, int par4, boolean par5) {
/* 146 */     ArmorStats a = null;
/* 147 */     int lvl = 0;
/* 148 */     int enchanted = 0;
/*     */     
/* 150 */     if (this.armor_material == 0) a = OreSpawnMain.Ultimate_armorstats; 
/* 151 */     if (this.armor_material == 1) a = OreSpawnMain.LavaEel_armorstats; 
/* 152 */     if (this.armor_material == 2) a = OreSpawnMain.MothScale_armorstats; 
/* 153 */     if (this.armor_material == 3) a = OreSpawnMain.Emerald_armorstats; 
/* 154 */     if (this.armor_material == 4) a = OreSpawnMain.Experience_armorstats; 
/* 155 */     if (this.armor_material == 5) a = OreSpawnMain.Ruby_armorstats; 
/* 156 */     if (this.armor_material == 6) a = OreSpawnMain.Amethyst_armorstats; 
/* 157 */     if (this.armor_material == 7) a = OreSpawnMain.Pink_armorstats; 
/* 158 */     if (this.armor_material == 8) a = OreSpawnMain.TigersEye_armorstats; 
/* 159 */     if (this.armor_material == 9) a = OreSpawnMain.Peacock_armorstats; 
/* 160 */     if (this.armor_material == 10) a = OreSpawnMain.Mobzilla_armorstats; 
/* 161 */     if (this.armor_material == 11) a = OreSpawnMain.Royal_armorstats; 
/* 162 */     if (this.armor_material == 12) a = OreSpawnMain.Lapis_armorstats; 
/* 163 */     if (this.armor_material == 13) a = OreSpawnMain.Queen_armorstats;
/*     */ 
/*     */ 
/*     */     
/* 167 */     if (a != null) {
/* 168 */       enchanted = a.e_aquaaffinity + a.e_blastprotection + a.e_featherfalling + a.e_fireprotection;
/* 169 */       enchanted += a.e_projectileprotection + a.e_protection + a.e_respiration + a.e_unbreaking;
/* 170 */       if (enchanted > 0) {
/* 171 */         lvl = EnchantmentHelper.getEnchantmentLevel(Enchantment.protection.effectId, stack);
/* 172 */         if (lvl <= 0) lvl = EnchantmentHelper.getEnchantmentLevel(Enchantment.fireProtection.effectId, stack); 
/* 173 */         if (lvl <= 0) lvl = EnchantmentHelper.getEnchantmentLevel(Enchantment.blastProtection.effectId, stack); 
/* 174 */         if (lvl <= 0) lvl = EnchantmentHelper.getEnchantmentLevel(Enchantment.projectileProtection.effectId, stack); 
/* 175 */         if (lvl <= 0) lvl = EnchantmentHelper.getEnchantmentLevel(Enchantment.respiration.effectId, stack); 
/* 176 */         if (lvl <= 0) lvl = EnchantmentHelper.getEnchantmentLevel(Enchantment.aquaAffinity.effectId, stack); 
/* 177 */         if (lvl <= 0) lvl = EnchantmentHelper.getEnchantmentLevel(Enchantment.unbreaking.effectId, stack); 
/* 178 */         if (lvl <= 0) lvl = EnchantmentHelper.getEnchantmentLevel(Enchantment.featherFalling.effectId, stack); 
/* 179 */         if (lvl == 0) {
/* 180 */           if (a.e_protection != 0) stack.addEnchantment(Enchantment.protection, a.e_protection); 
/* 181 */           if (a.e_fireprotection != 0) stack.addEnchantment(Enchantment.fireProtection, a.e_fireprotection); 
/* 182 */           if (a.e_blastprotection != 0) stack.addEnchantment(Enchantment.blastProtection, a.e_blastprotection); 
/* 183 */           if (a.e_projectileprotection != 0) stack.addEnchantment(Enchantment.projectileProtection, a.e_projectileprotection); 
/* 184 */           if (a.e_unbreaking != 0) stack.addEnchantment(Enchantment.unbreaking, a.e_unbreaking); 
/* 185 */           if (this.armor_type == 3 && 
/* 186 */             a.e_featherfalling != 0) stack.addEnchantment(Enchantment.featherFalling, a.e_featherfalling);
/*     */           
/* 188 */           if (this.armor_type == 0) {
/* 189 */             if (a.e_respiration != 0) stack.addEnchantment(Enchantment.respiration, a.e_respiration); 
/* 190 */             if (a.e_aquaaffinity != 0) stack.addEnchantment(Enchantment.aquaAffinity, a.e_aquaaffinity);
/*     */           
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getArmorTexture(ItemStack armor, Entity e, int slot, String layer) {
/* 201 */     if (this.armor_type == 0 || this.armor_type == 1 || this.armor_type == 3) {
/*     */       
/* 203 */       if (this.armor_material == 0) {
/* 204 */         return "orespawn:ultimate_1.png";
/*     */       }
/* 206 */       if (this.armor_material == 1) {
/* 207 */         return "orespawn:lavaeel_1.png";
/*     */       }
/* 209 */       if (this.armor_material == 2) {
/* 210 */         return "orespawn:mothscale_1.png";
/*     */       }
/* 212 */       if (this.armor_material == 4) {
/* 213 */         return "orespawn:experience_1.png";
/*     */       }
/* 215 */       if (this.armor_material == 5) {
/* 216 */         return "orespawn:ruby_1.png";
/*     */       }
/* 218 */       if (this.armor_material == 6) {
/* 219 */         return "orespawn:amethyst_1.png";
/*     */       }
/* 221 */       if (this.armor_material == 7) {
/* 222 */         return "orespawn:pink_1.png";
/*     */       }
/* 224 */       if (this.armor_material == 8) {
/* 225 */         return "orespawn:tigerseye_1.png";
/*     */       }
/* 227 */       if (this.armor_material == 9) {
/* 228 */         return "orespawn:peacock_1.png";
/*     */       }
/* 230 */       if (this.armor_material == 10) {
/* 231 */         return "orespawn:mobzilla_1.png";
/*     */       }
/* 233 */       if (this.armor_material == 11) {
/* 234 */         return "orespawn:royal_1.png";
/*     */       }
/* 236 */       if (this.armor_material == 12) {
/* 237 */         return "orespawn:lapis_1.png";
/*     */       }
/* 239 */       if (this.armor_material == 13) {
/* 240 */         return "orespawn:queen_1.png";
/*     */       }
/* 242 */       return "orespawn:emerald_1.png";
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 247 */     if (this.armor_material == 0) {
/* 248 */       return "orespawn:ultimate_2.png";
/*     */     }
/* 250 */     if (this.armor_material == 1) {
/* 251 */       return "orespawn:lavaeel_2.png";
/*     */     }
/* 253 */     if (this.armor_material == 2) {
/* 254 */       return "orespawn:mothscale_2.png";
/*     */     }
/* 256 */     if (this.armor_material == 4) {
/* 257 */       return "orespawn:experience_2.png";
/*     */     }
/* 259 */     if (this.armor_material == 5) {
/* 260 */       return "orespawn:ruby_2.png";
/*     */     }
/* 262 */     if (this.armor_material == 6) {
/* 263 */       return "orespawn:amethyst_2.png";
/*     */     }
/* 265 */     if (this.armor_material == 7) {
/* 266 */       return "orespawn:pink_2.png";
/*     */     }
/* 268 */     if (this.armor_material == 8) {
/* 269 */       return "orespawn:tigerseye_2.png";
/*     */     }
/* 271 */     if (this.armor_material == 9) {
/* 272 */       return "orespawn:peacock_2.png";
/*     */     }
/* 274 */     if (this.armor_material == 10) {
/* 275 */       return "orespawn:mobzilla_2.png";
/*     */     }
/* 277 */     if (this.armor_material == 11) {
/* 278 */       return "orespawn:royal_2.png";
/*     */     }
/* 280 */     if (this.armor_material == 12) {
/* 281 */       return "orespawn:lapis_2.png";
/*     */     }
/* 283 */     if (this.armor_material == 13) {
/* 284 */       return "orespawn:queen_2.png";
/*     */     }
/* 286 */     return "orespawn:emerald_2.png";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
/* 292 */     ItemStack boots = null;
/* 293 */     Item ia = null;
/* 294 */     ItemOreSpawnArmor it = null;
/*     */ 
/*     */     
/* 297 */     if (this.armor_material == 11 || this.armor_material == 9)
/*     */     {
/* 299 */       if (player != null) {
/*     */         
/* 301 */         boots = player.getEquipmentInSlot(1);
/*     */         
/* 303 */         if (boots != null && ((
/* 304 */           boots.getItem() == OreSpawnMain.RoyalBoots && OreSpawnMain.RoyalGlideEnable != 0) || boots.getItem() == OreSpawnMain.PeacockFeatherBoots)) {
/*     */           
/* 306 */           if (player.motionY < -0.10000000149011612D) player.motionY = -0.10000000149011612D; 
/* 307 */           player.fallDistance = 0.0F;
/*     */         } 
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 314 */     if (this.armor_material == 13)
/*     */     {
/* 316 */       if (player != null) {
/*     */         
/* 318 */         boots = player.getEquipmentInSlot(1);
/*     */         
/* 320 */         if (boots != null && 
/* 321 */           boots.getItem() == OreSpawnMain.QueenBoots && OreSpawnMain.RoyalGlideEnable != 0) {
/*     */           
/* 323 */           if (player.motionY < -0.25D) player.motionY = -0.25D; 
/* 324 */           player.fallDistance = 0.0F;
/*     */         } 
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void registerIcons(IIconRegister iconRegister) {
/* 334 */     this.itemIcon = iconRegister.registerIcon("OreSpawn:" + getUnlocalizedName().substring(5));
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\ItemOreSpawnArmor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */