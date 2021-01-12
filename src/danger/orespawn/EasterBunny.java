/*     */ package danger.orespawn;
/*     */ 
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityAgeable;
/*     */ import net.minecraft.entity.EntityCreature;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.entity.ai.EntityAIAvoidEntity;
/*     */ import net.minecraft.entity.ai.EntityAIBase;
/*     */ import net.minecraft.entity.ai.EntityAILookIdle;
/*     */ import net.minecraft.entity.ai.EntityAIMate;
/*     */ import net.minecraft.entity.ai.EntityAIPanic;
/*     */ import net.minecraft.entity.ai.EntityAISwimming;
/*     */ import net.minecraft.entity.ai.EntityAIWatchClosest;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.monster.EntityMob;
/*     */ import net.minecraft.entity.passive.EntityAnimal;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Items;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class EasterBunny
/*     */   extends EntityAnimal
/*     */ {
/*  43 */   private float moveSpeed = 0.45F;
/*     */ 
/*     */   
/*     */   public EasterBunny(World par1World) {
/*  47 */     super(par1World);
/*     */     
/*  49 */     setSize(0.5F, 0.75F);
/*  50 */     this.moveSpeed = 0.45F;
/*  51 */     this.fireResistance = 100;
/*  52 */     this.experienceValue = 5;
/*  53 */     getNavigator().setAvoidsWater(true);
/*  54 */     this.tasks.addTask(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
/*  55 */     this.tasks.addTask(1, (EntityAIBase)new EntityAIMate(this, 1.0D));
/*  56 */     this.tasks.addTask(2, (EntityAIBase)new EntityAIAvoidEntity((EntityCreature)this, EntityMob.class, 8.0F, 1.0D, 1.399999976158142D));
/*  57 */     this.tasks.addTask(3, (EntityAIBase)new EntityAIAvoidEntity((EntityCreature)this, EntityPlayer.class, 8.0F, 1.0D, 1.399999976158142D));
/*  58 */     this.tasks.addTask(4, (EntityAIBase)new EntityAIPanic((EntityCreature)this, 1.5D));
/*  59 */     this.tasks.addTask(5, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityLiving.class, 8.0F));
/*  60 */     this.tasks.addTask(6, new MyEntityAIWanderALot((EntityCreature)this, 16, 1.0D));
/*  61 */     this.tasks.addTask(7, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
/*     */   }
/*     */ 
/*     */   
/*     */   protected void applyEntityAttributes() {
/*  66 */     super.applyEntityAttributes();
/*  67 */     getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(mygetMaxHealth());
/*  68 */     getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.moveSpeed);
/*  69 */     getAttributeMap().registerAttribute(SharedMonsterAttributes.attackDamage);
/*  70 */     getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(8.0D);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void entityInit() {
/*  75 */     super.entityInit();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onUpdate() {
/*  82 */     getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.moveSpeed);
/*  83 */     super.onUpdate();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean getCanSpawnHere() {
/*  88 */     if (this.posY < 50.0D) return false; 
/*  89 */     if (!this.worldObj.isDaytime()) return false; 
/*  90 */     EasterBunny target = null;
/*  91 */     target = (EasterBunny)this.worldObj.findNearestEntityWithinAABB(EasterBunny.class, this.boundingBox.expand(32.0D, 8.0D, 32.0D), (Entity)this);
/*  92 */     if (target != null)
/*     */     {
/*  94 */       return false;
/*     */     }
/*  96 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isAIEnabled() {
/* 105 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canBreatheUnderwater() {
/* 111 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public int mygetMaxHealth() {
/* 116 */     return 10;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getLivingSound() {
/* 124 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getHurtSound() {
/* 132 */     return "orespawn:duck_hurt";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getDeathSound() {
/* 140 */     return "orespawn:duck_hurt";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundVolume() {
/* 148 */     return 0.4F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Item getDropItem() {
/* 156 */     return Items.chicken;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void dropFewItems(boolean par1, int par2) {
/* 164 */     int var3 = 0;
/* 165 */     var3 = this.rand.nextInt(3);
/* 166 */     var3 += 2;
/* 167 */     for (int var4 = 0; var4 < var3; var4++)
/*     */     {
/* 169 */       dropItem(Items.chicken, 1);
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
/*     */   protected void updateAITick() {
/* 181 */     if (this.worldObj.rand.nextInt(200) == 1) setRevengeTarget(null); 
/* 182 */     super.updateAITick();
/* 183 */     if (this.worldObj.rand.nextInt(600) == 1) LayAnEgg(1 + this.worldObj.rand.nextInt(3));
/*     */   
/*     */   }
/*     */   
/*     */   private ItemStack LayAnEgg(int par1) {
/* 188 */     EntityItem var3 = null;
/* 189 */     int i = 0;
/* 190 */     Item index = null;
/* 191 */     int val = 0;
/* 192 */     ItemStack is = null;
/* 193 */     i = this.worldObj.rand.nextInt(115);
/* 194 */     switch (i) {
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       case 5:
/* 200 */         index = OreSpawnMain.GirlfriendEgg; break;
/* 201 */       case 6: index = OreSpawnMain.RedCowEgg; break;
/* 202 */       case 7: index = OreSpawnMain.GoldCowEgg; break;
/* 203 */       case 8: index = OreSpawnMain.EnchantedCowEgg; break;
/* 204 */       case 9: index = OreSpawnMain.MOTHRAEgg; break;
/* 205 */       case 10: index = OreSpawnMain.AloEgg; break;
/* 206 */       case 11: index = OreSpawnMain.CryoEgg; break;
/* 207 */       case 12: index = OreSpawnMain.CamaEgg; break;
/* 208 */       case 13: index = OreSpawnMain.VeloEgg; break;
/* 209 */       case 14: index = OreSpawnMain.HydroEgg; break;
/* 210 */       case 15: index = OreSpawnMain.BasilEgg; break;
/* 211 */       case 16: index = OreSpawnMain.DragonflyEgg; break;
/* 212 */       case 17: index = OreSpawnMain.EmperorScorpionEgg; break;
/* 213 */       case 18: index = OreSpawnMain.ScorpionEgg; break;
/* 214 */       case 19: index = OreSpawnMain.CaveFisherEgg; break;
/* 215 */       case 20: index = OreSpawnMain.SpyroEgg; break;
/* 216 */       case 21: index = OreSpawnMain.BaryonyxEgg; break;
/* 217 */       case 22: index = OreSpawnMain.GammaMetroidEgg; break;
/* 218 */       case 23: index = OreSpawnMain.CockateilEgg; break;
/* 219 */       case 24: index = OreSpawnMain.KyuubiEgg; break;
/* 220 */       case 25: index = OreSpawnMain.AlienEgg; break;
/* 221 */       case 26: index = OreSpawnMain.AttackSquidEgg; break;
/* 222 */       case 27: index = OreSpawnMain.WaterDragonEgg; break;
/* 223 */       case 28: index = OreSpawnMain.CephadromeEgg; break;
/* 224 */       case 29: index = OreSpawnMain.DragonEgg; break;
/* 225 */       case 30: index = OreSpawnMain.KrakenEgg; break;
/* 226 */       case 31: index = OreSpawnMain.LizardEgg; break;
/* 227 */       case 32: index = OreSpawnMain.BeeEgg; break;
/* 228 */       case 33: index = OreSpawnMain.TrooperBugEgg; break;
/* 229 */       case 34: index = OreSpawnMain.SpitBugEgg; break;
/* 230 */       case 35: index = OreSpawnMain.StinkBugEgg; break;
/* 231 */       case 36: index = OreSpawnMain.OstrichEgg; break;
/* 232 */       case 37: index = OreSpawnMain.GazelleEgg; break;
/* 233 */       case 38: index = OreSpawnMain.ChipmunkEgg; break;
/* 234 */       case 39: index = OreSpawnMain.CreepingHorrorEgg; break;
/* 235 */       case 40: index = OreSpawnMain.TerribleTerrorEgg; break;
/* 236 */       case 41: index = OreSpawnMain.CliffRacerEgg; break;
/* 237 */       case 42: index = OreSpawnMain.TriffidEgg; break;
/* 238 */       case 43: index = OreSpawnMain.PitchBlackEgg; break;
/* 239 */       case 44: index = OreSpawnMain.LurkingTerrorEgg; break;
/* 240 */       case 45: index = OreSpawnMain.GodzillaEgg; break;
/* 241 */       case 46: index = OreSpawnMain.SmallWormEgg; break;
/* 242 */       case 47: index = OreSpawnMain.MediumWormEgg; break;
/* 243 */       case 48: index = OreSpawnMain.LargeWormEgg; break;
/* 244 */       case 49: index = OreSpawnMain.CassowaryEgg; break;
/* 245 */       case 50: index = OreSpawnMain.CloudSharkEgg; break;
/* 246 */       case 51: index = OreSpawnMain.GoldFishEgg; break;
/* 247 */       case 52: index = OreSpawnMain.LeafMonsterEgg; break;
/* 248 */       case 53: index = OreSpawnMain.TshirtEgg; break;
/* 249 */       case 54: index = OreSpawnMain.EnderKnightEgg; break;
/* 250 */       case 55: index = OreSpawnMain.EnderReaperEgg; break;
/* 251 */       case 56: index = OreSpawnMain.BeaverEgg; break;
/* 252 */       case 57: index = OreSpawnMain.RotatorEgg; break;
/* 253 */       case 58: index = OreSpawnMain.VortexEgg; break;
/* 254 */       case 59: index = OreSpawnMain.PeacockEgg; break;
/* 255 */       case 60: index = OreSpawnMain.FairyEgg; break;
/* 256 */       case 61: index = OreSpawnMain.DungeonBeastEgg; break;
/* 257 */       case 62: index = OreSpawnMain.RatEgg; break;
/* 258 */       case 63: index = OreSpawnMain.FlounderEgg; break;
/* 259 */       case 64: index = OreSpawnMain.WhaleEgg; break;
/* 260 */       case 65: index = OreSpawnMain.IrukandjiEgg; break;
/* 261 */       case 66: index = OreSpawnMain.SkateEgg; break;
/* 262 */       case 67: index = OreSpawnMain.UrchinEgg; break;
/* 263 */       case 68: index = OreSpawnMain.Robot1Egg; break;
/* 264 */       case 69: index = OreSpawnMain.Robot2Egg; break;
/* 265 */       case 70: index = OreSpawnMain.Robot3Egg; break;
/* 266 */       case 71: index = OreSpawnMain.Robot4Egg; break;
/* 267 */       case 72: index = OreSpawnMain.GhostEgg; break;
/* 268 */       case 73: index = OreSpawnMain.GhostSkellyEgg; break;
/* 269 */       case 74: index = OreSpawnMain.BrownAntEgg; break;
/* 270 */       case 75: index = OreSpawnMain.RedAntEgg; break;
/* 271 */       case 76: index = OreSpawnMain.RainbowAntEgg; break;
/* 272 */       case 77: index = OreSpawnMain.UnstableAntEgg; break;
/* 273 */       case 78: index = OreSpawnMain.TermiteEgg; break;
/* 274 */       case 79: index = OreSpawnMain.ButterflyEgg; break;
/* 275 */       case 80: index = OreSpawnMain.MothEgg; break;
/* 276 */       case 81: index = OreSpawnMain.MosquitoEgg; break;
/* 277 */       case 82: index = OreSpawnMain.FireflyEgg; break;
/* 278 */       case 83: index = OreSpawnMain.TRexEgg; break;
/* 279 */       case 84: index = OreSpawnMain.HerculesEgg; break;
/* 280 */       case 85: index = OreSpawnMain.MantisEgg; break;
/* 281 */       case 86: index = OreSpawnMain.StinkyEgg; break;
/* 282 */       case 87: index = OreSpawnMain.Robot5Egg; break;
/* 283 */       case 88: index = OreSpawnMain.CoinEgg; break;
/* 284 */       case 89: index = OreSpawnMain.BoyfriendEgg; break;
/* 285 */       case 90: index = OreSpawnMain.TheKingEgg; break;
/* 286 */       case 91: index = OreSpawnMain.ThePrinceEgg; break;
/* 287 */       case 92: index = OreSpawnMain.EasterBunnyEgg; break;
/* 288 */       case 93: index = OreSpawnMain.MolenoidEgg; break;
/* 289 */       case 94: index = OreSpawnMain.SeaMonsterEgg; break;
/* 290 */       case 95: index = OreSpawnMain.SeaViperEgg; break;
/* 291 */       case 96: index = OreSpawnMain.CaterKillerEgg; break;
/* 292 */       case 97: index = OreSpawnMain.LeonEgg; break;
/* 293 */       case 98: index = OreSpawnMain.HammerheadEgg; break;
/* 294 */       case 99: index = OreSpawnMain.RubberDuckyEgg; break;
/* 295 */       case 100: index = OreSpawnMain.CrystalCowEgg; break;
/* 296 */       case 101: index = OreSpawnMain.CriminalEgg; break;
/* 297 */       case 102: index = OreSpawnMain.TheQueenEgg; break;
/* 298 */       case 103: index = OreSpawnMain.BrutalflyEgg; break;
/* 299 */       case 104: index = OreSpawnMain.NastysaurusEgg; break;
/* 300 */       case 105: index = OreSpawnMain.PointysaurusEgg; break;
/* 301 */       case 106: index = OreSpawnMain.CricketEgg; break;
/* 302 */       case 107: index = OreSpawnMain.ThePrincessEgg; break;
/* 303 */       case 108: index = OreSpawnMain.FrogEgg; break;
/* 304 */       case 109: index = OreSpawnMain.JefferyEgg; break;
/* 305 */       case 110: index = OreSpawnMain.AntRobotEgg; break;
/* 306 */       case 111: index = OreSpawnMain.SpiderRobotEgg; break;
/* 307 */       case 112: index = OreSpawnMain.SpiderDriverEgg; break;
/* 308 */       case 113: index = OreSpawnMain.CrabEgg;
/*     */         break;
/*     */       default:
/* 311 */         index = null;
/*     */         break;
/*     */     } 
/*     */     
/* 315 */     if (index == null) return null;
/*     */     
/* 317 */     is = new ItemStack(index, par1, val);
/*     */     
/* 319 */     var3 = new EntityItem(this.worldObj, this.posX + OreSpawnMain.OreSpawnRand.nextInt(2) - OreSpawnMain.OreSpawnRand.nextInt(2), this.posY + 1.0D, this.posZ + OreSpawnMain.OreSpawnRand.nextInt(2) - OreSpawnMain.OreSpawnRand.nextInt(2), is);
/*     */     
/* 321 */     if (var3 != null) this.worldObj.spawnEntityInWorld((Entity)var3); 
/* 322 */     return is;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean canDespawn() {
/* 330 */     if (isChild()) {
/* 331 */       enablePersistence();
/* 332 */       return false;
/*     */     } 
/* 334 */     if (isNoDespawnRequired()) return false; 
/* 335 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public EntityAgeable createChild(EntityAgeable entityageable) {
/* 340 */     return (EntityAgeable)spawnBabyAnimal(entityageable);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EasterBunny spawnBabyAnimal(EntityAgeable par1EntityAgeable) {
/* 346 */     return new EasterBunny(this.worldObj);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isWheat(ItemStack par1ItemStack) {
/* 354 */     return (par1ItemStack != null && par1ItemStack.getItem() == Items.apple);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isBreedingItem(ItemStack par1ItemStack) {
/* 363 */     return (par1ItemStack.getItem() == OreSpawnMain.MyCrystalApple);
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\EasterBunny.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */