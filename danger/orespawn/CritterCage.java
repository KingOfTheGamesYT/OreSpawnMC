/*     */ package danger.orespawn;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.creativetab.CreativeTabs;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityList;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.IEntityLivingData;
/*     */ import net.minecraft.entity.monster.EntitySkeleton;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.Item;
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
/*     */ public class CritterCage
/*     */   extends Item
/*     */ {
/*  29 */   public int cage_id = 0;
/*     */ 
/*     */   
/*     */   public CritterCage(int i, int j) {
/*  33 */     this.cage_id = j;
/*  34 */     this.maxStackSize = 16;
/*  35 */     setCreativeTab(CreativeTabs.tabMisc);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
/*  45 */     CritterCage cc = (CritterCage)OreSpawnMain.CageEmpty;
/*     */ 
/*     */     
/*  48 */     if (this.cage_id == cc.cage_id) {
/*     */       
/*  50 */       if (!par3EntityPlayer.capabilities.isCreativeMode)
/*     */       {
/*  52 */         par1ItemStack.stackSize--;
/*     */       }
/*     */       
/*  55 */       par2World.playSoundAtEntity((Entity)par3EntityPlayer, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
/*     */       
/*  57 */       if (!par2World.isRemote)
/*     */       {
/*     */         
/*  60 */         par2World.spawnEntityInWorld((Entity)new EntityCage(par2World, par3EntityPlayer, this.cage_id));
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/*  65 */     return par1ItemStack;
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
/*     */ 
/*     */   
/*     */   public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10) {
/*  79 */     CritterCage cc = (CritterCage)OreSpawnMain.CageEmpty;
/*     */ 
/*     */ 
/*     */     
/*  83 */     if (this.cage_id == cc.cage_id)
/*     */     {
/*     */       
/*  86 */       return false;
/*     */     }
/*     */ 
/*     */     
/*  90 */     for (int var3 = 0; var3 < 6; var3++) {
/*     */       
/*  92 */       par2EntityPlayer.worldObj.spawnParticle("smoke", (par4 + 0.5F), (par5 + 1.25F), (par6 + 0.5F), 0.0D, 0.0D, 0.0D);
/*  93 */       par2EntityPlayer.worldObj.spawnParticle("explode", (par4 + 0.5F), (par5 + 1.25F), (par6 + 0.5F), 0.0D, 0.0D, 0.0D);
/*  94 */       par2EntityPlayer.worldObj.spawnParticle("reddust", (par4 + 0.5F), (par5 + 1.25F), (par6 + 0.5F), 0.0D, 0.0D, 0.0D);
/*     */     } 
/*  96 */     par2EntityPlayer.worldObj.playSoundAtEntity((Entity)par2EntityPlayer, "random.explode", 1.0F, 1.5F);
/*     */     
/*  98 */     if (par3World.isRemote)
/*     */     {
/*     */       
/* 101 */       return true;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 107 */     int entityID = 0;
/* 108 */     int skelly_type = 0;
/* 109 */     String name = null;
/*     */     
/* 111 */     switch (this.cage_id) {
/*     */       case 161:
/* 113 */         entityID = 52; break;
/*     */       case 162:
/* 115 */         entityID = 65; break;
/*     */       case 163:
/* 117 */         entityID = 92; break;
/*     */       case 164:
/* 119 */         entityID = 90; break;
/*     */       case 165:
/* 121 */         entityID = 94; break;
/*     */       case 166:
/* 123 */         entityID = 93; break;
/*     */       case 167:
/* 125 */         entityID = 50; break;
/*     */       case 188:
/* 127 */         skelly_type = 1;
/*     */       case 168:
/* 129 */         entityID = 51; break;
/*     */       case 169:
/* 131 */         entityID = 54; break;
/*     */       case 170:
/* 133 */         entityID = 55; break;
/*     */       case 171:
/* 135 */         entityID = 56; break;
/*     */       case 172:
/* 137 */         entityID = 57; break;
/*     */       case 173:
/* 139 */         entityID = 58; break;
/*     */       case 174:
/* 141 */         entityID = 59; break;
/*     */       case 175:
/* 143 */         entityID = 60; break;
/*     */       case 176:
/* 145 */         entityID = 62; break;
/*     */       case 177:
/* 147 */         entityID = 66; break;
/*     */       case 178:
/* 149 */         entityID = 91; break;
/*     */       case 179:
/* 151 */         entityID = 95; break;
/*     */       case 180:
/* 153 */         entityID = 96; break;
/*     */       case 181:
/* 155 */         entityID = 98; break;
/*     */       case 182:
/* 157 */         entityID = 61; break;
/*     */       case 184:
/* 159 */         entityID = 63; break;
/*     */       case 185:
/* 161 */         entityID = 97; break;
/*     */       case 186:
/* 163 */         entityID = 99; break;
/*     */       case 187:
/* 165 */         entityID = 64; break;
/*     */       case 253:
/* 167 */         entityID = 100; break;
/*     */       case 217:
/* 169 */         entityID = 120; break;
/*     */       case 183:
/* 171 */         name = "Girlfriend"; break;
/*     */       case 215:
/* 173 */         name = "Boyfriend"; break;
/*     */       case 189:
/* 175 */         name = "Apple Cow"; break;
/*     */       case 190:
/* 177 */         name = "Golden Apple Cow"; break;
/*     */       case 191:
/* 179 */         name = "Enchanted Golden Apple Cow"; break;
/*     */       case 208:
/* 181 */         name = "Mothra"; break;
/*     */       case 209:
/* 183 */         name = "Alosaurus"; break;
/*     */       case 210:
/* 185 */         name = "Cryolophosaurus"; break;
/*     */       case 211:
/* 187 */         name = "Camarasaurus"; break;
/*     */       case 212:
/* 189 */         name = "Velocity Raptor"; break;
/*     */       case 213:
/* 191 */         name = "Hydrolisc"; break;
/*     */       case 214:
/* 193 */         name = "Basilisk"; break;
/*     */       case 220:
/* 195 */         name = "Dragonfly"; break;
/*     */       case 222:
/* 197 */         name = "Emperor Scorpion"; break;
/*     */       case 224:
/* 199 */         name = "Scorpion"; break;
/*     */       case 226:
/* 201 */         name = "CaveFisher"; break;
/*     */       case 228:
/* 203 */         name = "Baby Dragon"; break;
/*     */       case 230:
/* 205 */         name = "Baryonyx"; break;
/*     */       case 232:
/* 207 */         name = "WTF?"; break;
/*     */       case 234:
/* 209 */         name = "Bird"; break;
/*     */       case 236:
/* 211 */         name = "Kyuubi"; break;
/*     */       case 238:
/* 213 */         name = "Alien"; break;
/*     */       case 240:
/* 215 */         name = "Attack Squid"; break;
/*     */       case 242:
/* 217 */         name = "Water Dragon"; break;
/*     */       case 244:
/* 219 */         name = "The Kraken"; break;
/*     */       case 246:
/* 221 */         name = "Lizard"; break;
/*     */       case 248:
/* 223 */         name = "Cephadrome"; break;
/*     */       case 250:
/* 225 */         name = "Dragon"; break;
/*     */       case 252:
/* 227 */         name = "Bee"; break;
/*     */       case 255:
/* 229 */         name = "Firefly"; break;
/*     */       case 256:
/* 231 */         name = "Chipmunk"; break;
/*     */       case 257:
/* 233 */         name = "Gazelle"; break;
/*     */       case 258:
/* 235 */         name = "Ostrich"; break;
/*     */       case 259:
/* 237 */         name = "Jumpy Bug"; break;
/*     */       case 260:
/* 239 */         name = "Spit Bug"; break;
/*     */       case 261:
/* 241 */         name = "Stink Bug"; break;
/*     */       case 268:
/* 243 */         name = "Creeping Horror"; break;
/*     */       case 269:
/* 245 */         name = "Terrible Terror"; break;
/*     */       case 270:
/* 247 */         name = "Cliff Racer"; break;
/*     */       case 271:
/* 249 */         name = "Triffid"; break;
/*     */       case 272:
/* 251 */         name = "Nightmare"; break;
/*     */       case 273:
/* 253 */         name = "Lurking Terror"; break;
/*     */       case 281:
/* 255 */         name = "Small Worm"; break;
/*     */       case 283:
/* 257 */         name = "Large Worm"; break;
/*     */       case 282:
/* 259 */         name = "Medium Worm"; break;
/*     */       case 284:
/* 261 */         name = "Cassowary"; break;
/*     */       case 285:
/* 263 */         name = "Cloud Shark"; break;
/*     */       case 286:
/* 265 */         name = "Gold Fish"; break;
/*     */       case 287:
/* 267 */         name = "Leaf Monster"; break;
/*     */       case 296:
/* 269 */         name = "Ender Knight"; break;
/*     */       case 297:
/* 271 */         name = "Ender Reaper"; break;
/*     */       case 300:
/* 273 */         name = "Beaver"; break;
/*     */       case 323:
/* 275 */         name = "Crystal Urchin"; break;
/*     */       case 319:
/* 277 */         name = "Flounder"; break;
/*     */       case 322:
/* 279 */         name = "Skate"; break;
/*     */       case 313:
/* 281 */         name = "Rotator"; break;
/*     */       case 315:
/* 283 */         name = "Peacock"; break;
/*     */       case 316:
/* 285 */         name = "Fairy"; break;
/*     */       case 317:
/* 287 */         name = "Dungeon Beast"; break;
/*     */       case 314:
/* 289 */         name = "Vortex"; break;
/*     */       case 318:
/* 291 */         name = "Rat"; break;
/*     */       case 320:
/* 293 */         name = "Whale"; break;
/*     */       case 321:
/* 295 */         name = "Irukandji"; break;
/*     */       case 345:
/* 297 */         name = "T. Rex"; break;
/*     */       case 346:
/* 299 */         name = "Hercules Beetle"; break;
/*     */       case 347:
/* 301 */         name = "Mantis"; break;
/*     */       case 348:
/* 303 */         name = "Stinky"; break;
/*     */       case 150:
/* 305 */         name = "Easter Bunny"; break;
/*     */       case 151:
/* 307 */         name = "CaterKiller"; break;
/*     */       case 152:
/* 309 */         name = "Molenoid"; break;
/*     */       case 153:
/* 311 */         name = "Sea Monster"; break;
/*     */       case 154:
/* 313 */         name = "Sea Viper"; break;
/*     */       case 357:
/* 315 */         name = "Leonopteryx"; break;
/*     */       case 359:
/* 317 */         name = "Hammerhead"; break;
/*     */       case 361:
/* 319 */         name = "Rubber Ducky"; break;
/*     */       case 216:
/* 321 */         name = "Crystal Apple Cow"; break;
/*     */       case 218:
/* 323 */         name = "Criminal"; break;
/*     */       case 373:
/* 325 */         name = "Brutalfly"; break;
/*     */       case 374:
/* 327 */         name = "Nastysaurus"; break;
/*     */       case 375:
/* 329 */         name = "Pointysaurus"; break;
/*     */       case 376:
/* 331 */         name = "Cricket"; break;
/*     */       case 377:
/* 333 */         name = "Frog"; break;
/*     */       case 382:
/* 335 */         name = "Spider Driver"; break;
/*     */       case 384:
/* 337 */         name = "Crab";
/*     */         break;
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 344 */     if (entityID != 0 || name != null) {
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 349 */       Entity ent = null;
/* 350 */       ent = spawnCreature(par3World, entityID, name, par4 + 0.5D, par5 + 1.1D, par6 + 0.5D);
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 355 */       if (ent != null) {
/* 356 */         ent.dropItem(OreSpawnMain.CageEmpty, 1);
/*     */ 
/*     */         
/* 359 */         if (entityID == 51 && skelly_type != 0) {
/*     */           
/* 361 */           EntitySkeleton sk = (EntitySkeleton)ent;
/* 362 */           sk.setSkeletonType(skelly_type);
/*     */         } 
/*     */         
/* 365 */         if (ent instanceof EntityLiving && par1ItemStack.hasDisplayName())
/*     */         {
/* 367 */           ((EntityLiving)ent).setCustomNameTag(par1ItemStack.getDisplayName());
/*     */         }
/*     */       }
/*     */     
/*     */     } else {
/*     */       
/* 373 */       return false;
/*     */     } 
/*     */ 
/*     */     
/* 377 */     if (!par2EntityPlayer.capabilities.isCreativeMode)
/*     */     {
/* 379 */       par1ItemStack.stackSize--;
/*     */     }
/*     */     
/* 382 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Entity spawnCreature(World par0World, int par1, String name, double par2, double par4, double par6) {
/* 391 */     Entity var8 = null;
/*     */ 
/*     */     
/* 394 */     if (name == null) {
/* 395 */       var8 = EntityList.createEntityByID(par1, par0World);
/*     */     } else {
/* 397 */       var8 = EntityList.createEntityByName(name, par0World);
/*     */     } 
/*     */     
/* 400 */     if (var8 != null) {
/*     */ 
/*     */       
/* 403 */       var8.setLocationAndAngles(par2, par4, par6, par0World.rand.nextFloat() * 360.0F, 0.0F);
/*     */ 
/*     */       
/* 406 */       if ((par1 == 100 || par1 == 120) && var8 instanceof EntityLiving) {
/*     */         
/* 408 */         EntityLiving sk = (EntityLiving)var8;
/* 409 */         sk.onSpawnWithEgg((IEntityLivingData)null);
/*     */       } 
/* 411 */       par0World.spawnEntityInWorld(var8);
/*     */       
/* 413 */       ((EntityLiving)var8).playLivingSound();
/*     */     } 
/*     */     
/* 416 */     return var8;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void registerIcons(IIconRegister iconRegister) {
/* 425 */     this.itemIcon = iconRegister.registerIcon("OreSpawn:" + getUnlocalizedName().substring(5));
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\CritterCage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */