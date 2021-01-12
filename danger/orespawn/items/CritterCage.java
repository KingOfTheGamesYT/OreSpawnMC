/*     */ package danger.orespawn.items;
/*     */ 
/*     */ import danger.orespawn.entity.EntityCage;
/*     */ import danger.orespawn.init.ModItems;
/*     */ import java.util.ArrayList;
/*     */ import net.minecraft.creativetab.CreativeTabs;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityList;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.SoundEvents;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.ActionResult;
/*     */ import net.minecraft.util.EnumActionResult;
/*     */ import net.minecraft.util.EnumFacing;
/*     */ import net.minecraft.util.EnumHand;
/*     */ import net.minecraft.util.EnumParticleTypes;
/*     */ import net.minecraft.util.SoundCategory;
/*     */ import net.minecraft.util.math.BlockPos;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CritterCage
/*     */   extends ItemBase
/*     */ {
/*  44 */   private static ArrayList<CritterCage> critterCages = new ArrayList<>();
/*     */   
/*     */   private final float chance;
/*     */   
/*     */   public static final int entityIDOffset = 10;
/*     */   int entityID;
/*     */   
/*     */   public CritterCage(int entityID, String unlocalizedName) {
/*  52 */     this(entityID, unlocalizedName, 1.0F);
/*     */   }
/*     */   
/*     */   public CritterCage(int entityID, String unlocalizedName, float chance) {
/*  56 */     super(unlocalizedName);
/*  57 */     this.maxStackSize = 16;
/*  58 */     setCreativeTab(CreativeTabs.MISC);
/*     */     
/*  60 */     this.entityID = entityID + 10;
/*  61 */     this.chance = chance;
/*     */     
/*  63 */     critterCages.add(this);
/*     */   }
/*     */ 
/*     */   
/*     */   public float getChance() {
/*  68 */     return this.chance;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
/*  77 */     ItemStack stack = player.getHeldItem(hand);
/*     */     
/*  79 */     EnumActionResult result = handleRightClick(world, player, hand, player.getPosition(), false);
/*     */     
/*  81 */     if (result == EnumActionResult.SUCCESS)
/*     */     {
/*  83 */       if (!player.isCreative())
/*     */       {
/*  85 */         stack.shrink(1);
/*     */       }
/*     */     }
/*  88 */     return new ActionResult(result, stack);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing blockside, float p_180614_6_, float p_180614_7_, float p_180614_8_) {
/*  94 */     EnumActionResult result = handleRightClick(world, player, hand, pos, true);
/*  95 */     if (result != EnumActionResult.FAIL && !player.isCreative())
/*     */     {
/*  97 */       player.getHeldItem(hand).shrink(1);
/*     */     }
/*  99 */     return result;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private EnumActionResult handleRightClick(World world, EntityPlayer entityPlayer, EnumHand hand, BlockPos position, boolean clickingOnBlock) {
/* 105 */     System.out.println(this.entityID);
/*     */     
/* 107 */     if (this.entityID == 0) {
/*     */       
/* 109 */       System.out.println("Throwing empty cage");
/* 110 */       if (!world.isRemote) {
/*     */         
/* 112 */         EntityCage ec = new EntityCage(world, entityPlayer, this.entityID, null);
/* 113 */         ec.shoot((Entity)entityPlayer, entityPlayer.rotationPitch, entityPlayer.rotationYaw, 0.0F, 1.5F, 1.0F);
/* 114 */         world.spawnEntity((Entity)ec);
/*     */       } 
/*     */       
/* 117 */       world.playSound(entityPlayer, entityPlayer.getPosition(), SoundEvents.ENTITY_EGG_THROW, SoundCategory.PLAYERS, 1.0F, 1.5F);
/* 118 */       return EnumActionResult.SUCCESS;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 123 */     System.out.println("Throwing filled cage");
/* 124 */     if (clickingOnBlock) {
/*     */ 
/*     */       
/* 127 */       for (int i = 0; i < 6; i++) {
/*     */         
/* 129 */         world.spawnParticle(EnumParticleTypes.SMOKE_LARGE, (position.getX() + 0.5F), (position.getY() + 1.25F), (position.getZ() + 0.5F), 0.0D, 0.0D, 0.0D, new int[] { 0 });
/* 130 */         world.spawnParticle(EnumParticleTypes.EXPLOSION_LARGE, (position.getX() + 0.5F), (position.getY() + 1.25F), (position.getZ() + 0.5F), 0.0D, 0.0D, 0.0D, new int[] { 0 });
/* 131 */         world.spawnParticle(EnumParticleTypes.REDSTONE, (position.getX() + 0.5F), (position.getY() + 1.25F), (position.getZ() + 0.5F), 0.0D, 0.0D, 0.0D, new int[] { 0 });
/*     */       } 
/* 133 */       world.playSound(entityPlayer, position, SoundEvents.ENTITY_GENERIC_EXPLODE, SoundCategory.PLAYERS, 1.0F, 1.5F);
/* 134 */       Entity summon = EntityList.createEntityByID(this.entityID - 10, world);
/*     */       
/* 136 */       summon.setPosition((position.getX() + 0.5F), (position.getY() + 1), (position.getZ() + 0.5F));
/* 137 */       world.spawnEntity(summon);
/*     */ 
/*     */       
/* 140 */       EntityItem empty = new EntityItem(world);
/* 141 */       empty.setItem(new ItemStack(ModItems.CageEmpty));
/* 142 */       empty.setPosition(position.getX(), position.getY(), position.getZ());
/* 143 */       world.spawnEntity((Entity)empty);
/*     */       
/* 145 */       ItemStack stack = entityPlayer.getHeldItem(hand);
/* 146 */       if (summon instanceof net.minecraft.entity.EntityLiving && stack.hasDisplayName())
/* 147 */         summon.setCustomNameTag(stack.getDisplayName()); 
/* 148 */       return EnumActionResult.SUCCESS;
/*     */     } 
/*     */ 
/*     */     
/* 152 */     if (!world.isRemote) {
/*     */       
/* 154 */       String name = null;
/* 155 */       if (entityPlayer.getHeldItem(hand).hasDisplayName())
/* 156 */         name = entityPlayer.getHeldItem(hand).getDisplayName(); 
/* 157 */       EntityCage ec = new EntityCage(world, entityPlayer, this.entityID, name);
/* 158 */       ec.shoot((Entity)entityPlayer, entityPlayer.rotationPitch, entityPlayer.rotationYaw, 0.0F, 1.5F, 1.0F);
/* 159 */       world.spawnEntity((Entity)ec);
/*     */     } 
/*     */     
/* 162 */     world.playSound(entityPlayer, entityPlayer.getPosition(), SoundEvents.ENTITY_EGG_THROW, SoundCategory.PLAYERS, 1.0F, 1.5F);
/* 163 */     return EnumActionResult.SUCCESS;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static CritterCage getCageFromEntity(Entity e) {
/*     */     int ID;
/* 171 */     if (e == null) {
/* 172 */       ID = 0;
/*     */     } else {
/* 174 */       ID = EntityList.getID(e.getClass());
/* 175 */     }  for (CritterCage cc : critterCages) {
/*     */       
/* 177 */       if (cc.entityID == ID + 10)
/* 178 */         return cc; 
/*     */     } 
/* 180 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.2-deobf.jar!\danger\orespawn\items\CritterCage.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */